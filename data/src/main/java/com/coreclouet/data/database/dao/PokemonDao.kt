package com.coreclouet.data.database.dao

import androidx.room.*
import com.coreclouet.data.database.POKEMON_TABLE_NAME
import com.coreclouet.data.database.model.PokemonEntity
import com.coreclouet.data.database.model.PokemonWithAllEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemon(pokemonEntity: PokemonEntity)

    @Query("SELECT pokemonName FROM $POKEMON_TABLE_NAME")
    suspend fun getPokemonsNames(): List<String>?

    @Query("SELECT * FROM $POKEMON_TABLE_NAME")
    suspend fun getPokemons(): List<PokemonEntity>?

    @Query("SELECT * FROM $POKEMON_TABLE_NAME WHERE pokemonName=:name")
    suspend fun getPokemon(name: String): PokemonEntity?

    @Query("SELECT * FROM $POKEMON_TABLE_NAME WHERE pokemonId=:id")
    suspend fun getPokemon(id: Int): PokemonEntity?

    @Transaction
    @Query("SELECT * FROM $POKEMON_TABLE_NAME")
    suspend fun getPokemonsWithAll(): List<PokemonWithAllEntity>?

    @Transaction
    @Query("SELECT * FROM $POKEMON_TABLE_NAME WHERE pokemonId=:pokemonId")
    suspend fun getPokemonWithAll(pokemonId: Int): PokemonWithAllEntity?

    @Transaction
    @Query("SELECT * FROM $POKEMON_TABLE_NAME WHERE pokemonName=:pokemonName")
    suspend fun getPokemonWithAll(pokemonName: String): PokemonWithAllEntity?
}