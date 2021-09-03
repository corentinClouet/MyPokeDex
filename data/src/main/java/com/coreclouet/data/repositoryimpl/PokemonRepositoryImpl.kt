package com.coreclouet.data.repositoryimpl

import com.coreclouet.data.database.dao.PokemonDao
import com.coreclouet.data.networking.ApiService
import com.coreclouet.domain.model.Pokemon
import com.coreclouet.domain.repository.PokemonRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(
    private val apiService: ApiService,
    private val pokemonDao: PokemonDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PokemonRepository {

    override suspend fun getPokemonsNamesList(): List<String>? = withContext(dispatcher) {
        //check database result
        val dbPokemonsNames = pokemonDao.getPokemonsNames()
        if (!dbPokemonsNames.isNullOrEmpty()) return@withContext dbPokemonsNames
        //if database result null, check remote data
        val remoteResult = apiService.getPokemons()
        if (remoteResult.isSuccessful) {
            val pokemonsNamesListResponse = remoteResult.body()
            val resultList = mutableListOf<String>()
            pokemonsNamesListResponse?.results?.forEach {
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

    override suspend fun getPokemonsList(): List<Pokemon>? = withContext(dispatcher) {
        //check database result
        val dbPokemons = pokemonDao.getPokemonsWithAll()
        if (!dbPokemons.isNullOrEmpty()) return@withContext dbPokemons.map { it.mapToDomain() }
        //if database result null, check remote data
        val pokemonsNamesList = getPokemonsNamesList()
        pokemonsNamesList?.let {
            it.forEach { pokemonName ->
                //get data from BO and save it to DB
                getPokemon(pokemonName)
            }
        }
        val finalResult = pokemonDao.getPokemonsWithAll()
        return@withContext finalResult?.map { it.mapToDomain() }
    }

    override suspend fun getPokemon(name: String): Pokemon? = withContext(dispatcher) {
        //check database result
        val dbPokemonWithAll = pokemonDao.getPokemonWithAll(name)
        if (dbPokemonWithAll != null) return@withContext dbPokemonWithAll.mapToDomain()
        //if database result null, check remote data
        val remoteResult = apiService.getPokemonByName(name)
        if (remoteResult.isSuccessful) {
            val pokemonRemote = remoteResult.body()
            if (pokemonRemote != null) {
                //get pokemons species
                val pokemonSpeciesRemote = apiService.getPokemonSpecies(pokemonRemote.name).body()
                    ?: return@withContext null
/*                //save each ability of this pokemon
                pokemonRemote.abilities?.forEach { ability ->
                    //TODO save abilities
                }
                //save each move of this pokemon
                pokemonRemote.moves?.forEach { move ->
                    //TODO save move
                }
                //save each type of this pokemon
                pokemonRemote.types.forEach { type ->
                    //TODO save type
                }
                //save each stat of this pokemon
                pokemonRemote.stats?.forEach { stat ->
                    //TODO save stat
                }*/
                //return generation
                val dbMapPokemon = pokemonRemote.mapToRoomEntity(pokemonSpeciesRemote)
                pokemonDao.insertPokemon(dbMapPokemon)
                return@withContext pokemonDao.getPokemonWithAll(name)?.mapToDomain()
            }
        }
        return@withContext null
    }

}