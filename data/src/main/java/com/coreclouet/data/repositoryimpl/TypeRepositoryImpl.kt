package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.PokemonTypeCrossRefDao
import com.coreclouet.data.database.dao.TypeDao
import com.coreclouet.data.database.model.PokemonTypeCrossRefEntity
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Type
import com.coreclouet.domain.repository.TypeRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TypeRepositoryImpl(
    private val apiService: ApiService,
    private val typeDao: TypeDao,
    private val pokemonTypeCrossRefDao: PokemonTypeCrossRefDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : TypeRepository {

    override suspend fun getTypeFromPokemon(typeName: String, pokemonOwnerId: Int): Type? =
        withContext(dispatcher) {
            val typeDomain = getType(typeName)
            typeDomain?.let {
                //save cross ref between pokemon owner and this type (many to many ref)
                pokemonTypeCrossRefDao.insertPokemonTypeCrossRef(
                    PokemonTypeCrossRefEntity(
                        pokemonOwnerId,
                        typeDomain.id
                    )
                )
            }
            return@withContext typeDomain
        }

    override suspend fun getType(typeId: Int): Type? = withContext(dispatcher) {
        //check database result
        val dbType = typeDao.getType(typeId)
        if (dbType != null) return@withContext dbType.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getTypeById(typeId)
        if (remoteResult.isSuccessful) {
            val typeRemote = remoteResult.body()
            if (typeRemote != null) {
                //return generation
                val dbMapType = typeRemote.mapToRoomEntity()
                typeDao.insertType(dbMapType)
                return@withContext dbMapType.mapToDomain()
            }
        }
        return@withContext null
    }

    override suspend fun getType(typeName: String): Type? = withContext(dispatcher) {
        //check database result
        val dbType = typeDao.getType(typeName)
        if (dbType != null) return@withContext dbType.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getTypeByName(typeName)
        if (remoteResult.isSuccessful) {
            val typeRemote = remoteResult.body()
            if (typeRemote != null) {
                //return generation
                val dbMapType = typeRemote.mapToRoomEntity()
                typeDao.insertType(dbMapType)
                return@withContext dbMapType.mapToDomain()
            }
        }
        return@withContext null
    }

}