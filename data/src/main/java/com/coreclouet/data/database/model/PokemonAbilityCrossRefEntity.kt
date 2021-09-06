package com.coreclouet.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.coreclouet.data.database.POKEMON_ABILITY_CROSS_REF_TABLE_NAME

@Entity(tableName = POKEMON_ABILITY_CROSS_REF_TABLE_NAME, primaryKeys = ["pokemonId", "abilityId"])
data class PokemonAbilityCrossRefEntity(
    val pokemonId: Int,
    @ColumnInfo(index = true)
    val abilityId: Int
)