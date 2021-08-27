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
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) : VersionRepository {

    override suspend fun getVersionList(): List<String>? = withContext(dispatcher) {
        //check database result
        val dbVersions = versionDao.getVersionsNames()
        if (!dbVersions.isNullOrEmpty()) return@withContext dbVersions
        //if database result null, check remote data
        val remoteResult = apiService.getVersions()
        if (remoteResult.isSuccessful) {
            val versionListResponse = remoteResult.body()
            val resultList = mutableListOf<String>()
            versionListResponse?.results?.forEach { it.name?.let { name -> resultList.add(name) } }
            return@withContext resultList
        }
        return@withContext null
    }

    //TODO parse to Version object
    override suspend fun getVersion(name: String): Version? = withContext(dispatcher) {
        //check database result
        val dbVersion = versionDao.getVersion(name)
        if (dbVersion != null) return@withContext dbVersion
        //if database result null, check remote data
        val remoteResult = apiService.getVersionByName(name)
        return@withContext remoteResult.body()
    }

    override suspend fun getVersion(id: Long): Version? {
        TODO("Not yet implemented")
    }
}