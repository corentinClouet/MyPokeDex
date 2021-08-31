package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.VersionDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Version
import com.coreclouet.domain.repository.VersionRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VersionRepositoryImpl(
    private val apiService: ApiService,
    private val versionDao: VersionDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : VersionRepository {

    override suspend fun getVersionsList(): List<Version>? = withContext(dispatcher) {
        //check database result
        val dbVersions = versionDao.getVersions()
        if (!dbVersions.isNullOrEmpty()) return@withContext dbVersions.map { it.mapToDomain() }
        //if database result null, check remote data
        val versionsNamesList = getVersionsNamesList()
        versionsNamesList?.let {
            it.forEach { versionName ->
                //get data from BO and save it to DB
                getVersion(versionName)
            }
        }
        val finalResult = versionDao.getVersions()
        return@withContext finalResult?.map { it.mapToDomain() }
    }

    override suspend fun getVersionsNamesList(): List<String>? = withContext(dispatcher) {
        //check database result
        val dbVersionsNames = versionDao.getVersionsNames()
        if (!dbVersionsNames.isNullOrEmpty()) return@withContext dbVersionsNames
        //if database result null, check remote data
        val remoteResult = apiService.getVersions()
        if (remoteResult.isSuccessful) {
            val versionsNamesListResponse = remoteResult.body()
            val resultList = mutableListOf<String>()
            versionsNamesListResponse?.results?.forEach { it.name?.let { name -> resultList.add(name) } }
            return@withContext resultList
        }
        return@withContext null
    }

    override suspend fun getVersion(name: String): Version? = withContext(dispatcher) {
        //check database result
        val dbVersion = versionDao.getVersion(name)
        if (dbVersion != null) return@withContext dbVersion.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getVersionByName(name)
        if (remoteResult.isSuccessful) {
            val versionRemote = remoteResult.body()
            if (versionRemote != null) {
                val dbMapVersion = versionRemote.mapToRoomEntity()
                versionDao.insertVersion(dbMapVersion)
                return@withContext dbMapVersion.mapToDomain()
            }
        }
        return@withContext null
    }
}