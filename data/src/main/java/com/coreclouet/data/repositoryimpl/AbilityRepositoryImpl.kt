package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.AbilityDao
import com.coreclouet.data.database.dao.PokemonAbilityCrossRefDao
import com.coreclouet.data.database.model.PokemonAbilityCrossRefEntity
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Ability
import com.coreclouet.domain.repository.AbilityRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AbilityRepositoryImpl(
    private val apiService: ApiService,
    private val abilityDao: AbilityDao,
    private val pokemonAbilityCrossRefDao: PokemonAbilityCrossRefDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AbilityRepository {

    override suspend fun getAbilityFromPokemon(abilityName: String, pokemonOwnerId: Int): Ability? =
        withContext(dispatcher) {
            val abilityDomain = getAbility(abilityName)
            abilityDomain?.let {
                //save cross ref between pokemon owner and this ability (many to many ref)
                pokemonAbilityCrossRefDao.insertPokemonAbilityCrossRef(
                    PokemonAbilityCrossRefEntity(
                        pokemonOwnerId,
                        abilityDomain.id
                    )
                )
            }
            return@withContext abilityDomain
        }

    override suspend fun getAbility(abilityId: Int): Ability? = withContext(dispatcher) {
        //check database result
        val dbAbility = abilityDao.getAbility(abilityId)
        if (dbAbility != null) return@withContext dbAbility.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getAbilityById(abilityId)
        if (remoteResult.isSuccessful) {
            val abilityRemote = remoteResult.body()
            if (abilityRemote != null) {
                //return generation
                val dbMapAbility = abilityRemote.mapToRoomEntity()
                abilityDao.insertAbility(dbMapAbility)
                return@withContext dbMapAbility.mapToDomain()
            }
        }
        return@withContext null
    }

    override suspend fun getAbility(abilityName: String): Ability? = withContext(dispatcher) {
        //check database result
        val dbAbility = abilityDao.getAbility(abilityName)
        if (dbAbility != null) return@withContext dbAbility.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getAbilityByName(abilityName)
        if (remoteResult.isSuccessful) {
            val abilityRemote = remoteResult.body()
            if (abilityRemote != null) {
                //return generation
                val dbMapAbility = abilityRemote.mapToRoomEntity()
                abilityDao.insertAbility(dbMapAbility)
                return@withContext dbMapAbility.mapToDomain()
            }
        }
        return@withContext null
    }

}