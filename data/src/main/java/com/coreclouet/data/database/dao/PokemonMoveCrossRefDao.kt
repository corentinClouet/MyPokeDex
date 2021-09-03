package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.coreclouet.data.database.model.PokemonMoveCrossRefEntity

@Dao
interface PokemonMoveCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonMoveCrossRef(pokemonMoveCrossRefEntity: PokemonMoveCrossRefEntity)

}