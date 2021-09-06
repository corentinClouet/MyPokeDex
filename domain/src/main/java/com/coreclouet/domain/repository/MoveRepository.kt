package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Move

interface MoveRepository {
    suspend fun getMoveFromPokemon(moveName: String, pokemonOwnerId: Int): Move?
    suspend fun getMove(moveId: Int): Move?
    suspend fun getMove(moveName: String): Move?
}