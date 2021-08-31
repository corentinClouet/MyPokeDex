package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.VersionGroupDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.VersionGroup
import com.coreclouet.domain.repository.VersionGroupRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class VersionGroupRepositoryImpl(
    private val apiService: ApiService,
    private val versionGroupDao: VersionGroupDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : VersionGroupRepository {

    override suspend fun getVersionGroup(name: String): VersionGroup? = withContext(dispatcher) {
        //check database result
        val dbVersionGroup = versionGroupDao.getVersionGroup(name)
        if (dbVersionGroup != null) return@withContext dbVersionGroup.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getVersionGroupByName(name)
        if (remoteResult.isSuccessful) {
            val versionGroupRemote = remoteResult.body()
            if (versionGroupRemote != null) {
                val dbMapVersionGroup = versionGroupRemote.mapToRoomEntity()
                versionGroupDao.insertVersionGroup(dbMapVersionGroup)
                return@withContext dbMapVersionGroup.mapToDomain()
            }
        }
        return@withContext null
    }
}