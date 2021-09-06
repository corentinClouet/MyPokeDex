package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.coreclouet.data.database.model.PokemonTypeCrossRefEntity

@Dao
interface PokemonTypeCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonTypeCrossRef(pokemonTypeCrossRefEntity: PokemonTypeCrossRefEntity)

}