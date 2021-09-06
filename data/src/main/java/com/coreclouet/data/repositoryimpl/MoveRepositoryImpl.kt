package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.MoveDao
import com.coreclouet.data.database.dao.PokemonMoveCrossRefDao
import com.coreclouet.data.database.model.PokemonMoveCrossRefEntity
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Move
import com.coreclouet.domain.repository.MoveRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoveRepositoryImpl(
    private val apiService: ApiService,
    private val moveDao: MoveDao,
    private val pokemonMoveCrossRefDao: PokemonMoveCrossRefDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoveRepository {

    override suspend fun getMoveFromPokemon(moveName: String, pokemonOwnerId: Int): Move? =
        withContext(dispatcher) {
            val moveDomain = getMove(moveName)
            moveDomain?.let {
                //save cross ref between pokemon owner and this move (many to many ref)
                pokemonMoveCrossRefDao.insertPokemonMoveCrossRef(
                    PokemonMoveCrossRefEntity(
                        pokemonOwnerId,
                        moveDomain.id
                    )
                )
            }
            return@withContext moveDomain
        }

    override suspend fun getMove(moveId: Int): Move? = withContext(dispatcher) {
        //check database result
        val dbMove = moveDao.getMove(moveId)
        if (dbMove != null) return@withContext dbMove.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getMoveById(moveId)
        if (remoteResult.isSuccessful) {
            val moveRemote = remoteResult.body()
            if (moveRemote != null) {
                //return move
                val dbMapMove = moveRemote.mapToRoomEntity()
                moveDao.insertMove(dbMapMove)
                return@withContext dbMapMove.mapToDomain()
            }
        }
        return@withContext null
    }

    override suspend fun getMove(moveName: String): Move? = withContext(dispatcher) {
        //check database result
        val dbMove = moveDao.getMove(moveName)
        if (dbMove != null) return@withContext dbMove.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getMoveByName(moveName)
        if (remoteResult.isSuccessful) {
            val moveRemote = remoteResult.body()
            if (moveRemote != null) {
                //return move
                val dbMapMove = moveRemote.mapToRoomEntity()
                moveDao.insertMove(dbMapMove)
                return@withContext dbMapMove.mapToDomain()
            }
        }
        return@withContext null
    }

}