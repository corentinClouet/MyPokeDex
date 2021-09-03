package com.coreclouet.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.coreclouet.data.database.POKEMON_TYPE_CROSS_REF_TABLE_NAME

@Entity(tableName = POKEMON_TYPE_CROSS_REF_TABLE_NAME, primaryKeys = ["pokemonId", "typeId"])
data class PokemonTypeCrossRefEntity(
    val pokemonId: Int,
    @ColumnInfo(index = true)
    val typeId: Int
)