package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.GenerationDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Generation
import com.coreclouet.domain.repository.GenerationRepository
import com.coreclouet.domain.repository.VersionGroupRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GenerationRepositoryImpl(
    private val apiService: ApiService,
    private val generationDao: GenerationDao,
    private val versionGroupRepository: VersionGroupRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : GenerationRepository {

    override suspend fun getGenerationsList(): List<Generation>? = withContext(dispatcher) {
        //check database result
        val dbGenerations = generationDao.getGenerations()
        if (!dbGenerations.isNullOrEmpty()) return@withContext dbGenerations.map { it.mapToDomain() }
        //if database result null, check remote data
        val generationsNamesList = getGenerationsNamesList()
        generationsNamesList?.let {
            it.forEach { generationName ->
                //get data from BO and save it to DB
                getGeneration(generationName)
            }
        }
        val finalResult = generationDao.getGenerations()
        return@withContext finalResult?.map { it.mapToDomain() }
    }

    override suspend fun getGenerationsNamesList(): List<String>? = withContext(dispatcher) {
        //check database result
        val dbGenerationsNames = generationDao.getGenerationsNames()
        if (!dbGenerationsNames.isNullOrEmpty()) return@withContext dbGenerationsNames
        //if database result null, check remote data
        val remoteResult = apiService.getGenerations()
        if (remoteResult.isSuccessful) {
            val generationsNamesListResponse = remoteResult.body()
            val resultList = mutableListOf<String>()
            generationsNamesListResponse?.results?.forEach {
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

    override suspend fun getGeneration(name: String): Generation? = withContext(dispatcher) {
        //check database result
        val dbGeneration = generationDao.getGeneration(name)
        if (dbGeneration != null) return@withContext dbGeneration.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getGenerationByName(name)
        if (remoteResult.isSuccessful) {
            val generationRemote = remoteResult.body()
            if (generationRemote != null) {
                //save each version group of this generation
                generationRemote.versionGroups?.forEach { versionGroup ->
                    versionGroupRepository.getVersionGroup(versionGroup.name)
                }
                //return generation
                val dbMapGeneration = generationRemote.mapToRoomEntity()
                generationDao.insertGeneration(dbMapGeneration)
                return@withContext dbMapGeneration.mapToDomain()
            }
        }
        return@withContext null
    }

}