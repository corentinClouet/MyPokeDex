package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.*
import com.coreclouet.data.database.dao.StatDao
import com.coreclouet.data.database.model.StatEntity
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Stat
import com.coreclouet.domain.repository.StatRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StatRepositoryImpl(
    private val apiService: ApiService,
    private val statDao: StatDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : StatRepository {

    override suspend fun insertStat(stat: Stat) {
        //generate stat entity
        val statEntity = StatEntity(
            pokemonOwnerId = stat.pokemonOwnerId,
            hp = stat.hp,
            attack = stat.attack,
            defense = stat.defense,
            speAttack = stat.speAttack,
            speDefense = stat.speDefense,
            speed = stat.speed,
        )
        statDao.insertStat(statEntity)
    }

    override suspend fun getStat(pokemonOwnerId: Int): Stat? = withContext(dispatcher) {
        //check database result
        val dbStat = statDao.getStat(pokemonOwnerId)
        if (dbStat != null) return@withContext dbStat.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getPokemonById(pokemonOwnerId)
        if (remoteResult.isSuccessful) {
            val pokemonRemote = remoteResult.body()
            pokemonRemote?.stats?.let {
                //generate stat entity
                val statEntity = StatEntity(
                    pokemonOwnerId = pokemonOwnerId,
                    hp = it.filter { item -> item.stat.name == HP_STAT_NAME }[0].baseStat,
                    attack = it.filter { item -> item.stat.name == ATTACK_STAT_NAME }[0].baseStat,
                    defense = it.filter { item -> item.stat.name == DEFENSE_STAT_NAME }[0].baseStat,
                    speAttack = it.filter { item -> item.stat.name == SPE_ATT_STAT_NAME }[0].baseStat,
                    speDefense = it.filter { item -> item.stat.name == SPE_DEF_STAT_NAME }[0].baseStat,
                    speed = it.filter { item -> item.stat.name == SPEED_STAT_NAME }[0].baseStat
                )
                statDao.insertStat(statEntity)
                return@withContext statEntity.mapToDomain()
            }
        }
        return@withContext null
    }

}