package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Type

interface TypeRepository {
    suspend fun getTypeFromPokemon(typeName: String, pokemonOwnerId: Int): Type?
    suspend fun getType(typeId: Int): Type?
    suspend fun getType(typeName: String): Type?
}