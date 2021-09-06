package com.coreclouet.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.coreclouet.data.database.POKEMON_MOVE_CROSS_REF_TABLE_NAME

@Entity(tableName = POKEMON_MOVE_CROSS_REF_TABLE_NAME, primaryKeys = ["pokemonId", "moveId"])
data class PokemonMoveCrossRefEntity(
    val pokemonId: Int,
    @ColumnInfo(index = true)
    val moveId: Int
)