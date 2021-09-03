package com.coreclouet.data.database.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.coreclouet.domain.model.Pokemon

data class PokemonWithAllEntity(
    @Embedded val pokemonEntity: PokemonEntity,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "abilityId",
        associateBy = Junction(PokemonAbilityCrossRefEntity::class)
    )
    val abilities: List<AbilityEntity>?,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "moveId",
        associateBy = Junction(PokemonMoveCrossRefEntity::class)
    )
    val moves: List<MoveEntity>?,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "pokemonOwnerId"
    )
    val statEntity: StatEntity,
    @Relation(
        parentColumn = "pokemonId",
        entityColumn = "typeId",
        associateBy = Junction(PokemonTypeCrossRefEntity::class)
    )
    val typesEntity: List<TypeEntity>?,
) {
    fun mapToDomain(): Pokemon {
        return Pokemon(
            id = pokemonEntity.pokemonId,
            name = pokemonEntity.pokemonName,
            abilities = abilities?.map { it.mapToDomain() },
            baseXp = pokemonEntity.baseXp,
            height = pokemonEntity.height,
            encounters = null, //TODO fill encounters
            moves = moves?.map { it.mapToDomain() },
            order = pokemonEntity.order,
            defaultSprite = pokemonEntity.defaultSprite,
            officialSprite = pokemonEntity.officialSprite,
            stat = statEntity.mapToDomain(),
            types = typesEntity?.map { it.mapToDomain() },
            weight = pokemonEntity.weight,
            captureRate = pokemonEntity.captureRate,
            evolutionChain = null, //TODO fill evolution chain
            description = pokemonEntity.description,
            genderRate = pokemonEntity.genderRate,
            generationName = pokemonEntity.generationName,
            growthRateName = pokemonEntity.growthRateName,
            habitatName = pokemonEntity.habitatName,
            genderDifference = pokemonEntity.genderDifference,
            isBaby = pokemonEntity.isBaby,
            isLegendary = pokemonEntity.isLegendary,
            isMythical = pokemonEntity.isMythical,
            shapeName = pokemonEntity.shapeName,
            parkEncounters = null //TODO fill park encounters
        )
    }
}
