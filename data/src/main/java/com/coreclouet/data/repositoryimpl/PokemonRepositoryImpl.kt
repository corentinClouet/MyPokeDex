package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.PokemonDao
import com.coreclouet.data.database.dao.VersionDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Pokemon
import com.coreclouet.domain.model.Version
import com.coreclouet.domain.repository.PokemonRepository
import com.coreclouet.domain.repository.VersionRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val apiService: ApiService,
    private val pokemonDao: PokemonDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PokemonRepository {

    override suspend fun getPokemonsNamesList(): List<String>? {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonsList(): List<Pokemon>? {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemon(name: String): Pokemon? {
        TODO("Not yet implemented")
    }

}