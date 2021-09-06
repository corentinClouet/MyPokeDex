package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Pokemon

interface PokemonRepository {
    suspend fun getPokemonsNamesList(): List<String>?
    suspend fun getPokemonsList(): List<Pokemon>?
    suspend fun getPokemon(name: String): Pokemon?
}