package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.coreclouet.data.database.model.PokemonAbilityCrossRefEntity

@Dao
interface PokemonAbilityCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonAbilityCrossRef(pokemonAbilityCrossRefEntity: PokemonAbilityCrossRefEntity)

}