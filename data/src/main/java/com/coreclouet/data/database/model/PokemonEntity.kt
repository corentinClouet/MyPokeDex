package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.POKEMON_TABLE_NAME
import com.coreclouet.domain.model.Pokemon

@Entity(tableName = POKEMON_TABLE_NAME)
data class PokemonEntity(
    @PrimaryKey
    val pokemonId: Int,
    val pokemonName: String,
    val baseXp: Int,
    val height: Int,
    val order: Int,
    val defaultSprite: String,
    val officialSprite: String,
    val weight: Int,
    val captureRate: Int,
    val description: String,
    val genderRate: Int,
    val generationName: String,
    val growthRateName: String,
    val habitatName: String,
    val genderDifference: Boolean,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val shapeName: String,
)