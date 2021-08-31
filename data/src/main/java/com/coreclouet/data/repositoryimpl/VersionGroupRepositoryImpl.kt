package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.VersionGroupDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.VersionGroup
import com.coreclouet.domain.repository.VersionGroupRepository
import com.coreclouet.domain.repository.VersionRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VersionGroupRepositoryImpl(
    private val apiService: ApiService,
    private val versionGroupDao: VersionGroupDao,
    private val versionRepository: VersionRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : VersionGroupRepository {

    override suspend fun getVersionGroupList(): List<VersionGroup>? = withContext(dispatcher) {
        //check database result
        val dbVg = versionGroupDao.getVersionsGroups()
        if (!dbVg.isNullOrEmpty()) return@withContext dbVg.map { it.mapToDomain() }
        //if database result null, check remote data
        val vgNamesList = getVersionGroupNamesList()
        vgNamesList?.let {
            it.forEach { vgName ->
                //get data from BO and save it to DB
                getVersionGroup(vgName)
            }
        }
        val finalResult = versionGroupDao.getVersionsGroups()
        return@withContext finalResult?.map { it.mapToDomain() }
    }

    override suspend fun getVersionGroupNamesList(): List<String>? = withContext(dispatcher) {
        //check database result
        val dbVgNames = versionGroupDao.getVersionsGroupsNames()
        if (!dbVgNames.isNullOrEmpty()) return@withContext dbVgNames
        //if database result null, check remote data
        val remoteResult = apiService.getVersionsGroups()
        if (remoteResult.isSuccessful) {
            val vgListResponse = remoteResult.body()
            val resultList = mutableListOf<String>()
            vgListResponse?.results?.forEach {
                it.name.let { name ->
                    resultList.add(
                        name
                    )
                }
            }
            return@withContext resultList
        }
        return@withContext null
    }

    override suspend fun getVersionGroup(name: String): VersionGroup? = withContext(dispatcher) {
        //check database result
        val dbVersionGroup = versionGroupDao.getVersionGroup(name)
        if (dbVersionGroup != null) return@withContext dbVersionGroup.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getVersionGroupByName(name)
        if (remoteResult.isSuccessful) {
            val versionGroupRemote = remoteResult.body()
            if (versionGroupRemote != null) {
                //save each version of this version group
                versionGroupRemote.versions?.forEach { version ->
                    versionRepository.getVersion(version.name)
                }
                //return version group
                val dbMapVersionGroup = versionGroupRemote.mapToRoomEntity()
                versionGroupDao.insertVersionGroup(dbMapVersionGroup)
                return@withContext dbMapVersionGroup.mapToDomain()
            }
        }
        return@withContext null
    }

}