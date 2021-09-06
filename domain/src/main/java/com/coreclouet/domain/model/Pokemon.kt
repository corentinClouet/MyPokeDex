package com.coreclouet.domain.model

data class Pokemon(
    val id: Int,
    val name: String,
    val abilities: List<Ability>?,
    val baseXp: Int,
    val height: Int,
    val encounters: List<Encounter>?, //TODO complete Encounter object
    val moves: List<Move>?,
    val order: Int,
    val defaultSprite: String,
    val officialSprite: String,
    val stat: Stat?,
    val types: List<Type>?,
    val weight: Int,
    val captureRate: Int,
    val evolutionChain: Any?, //TODO create EvolutionChain object
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
    val parkEncounters: List<Any>?, //TODO create ParkEncounter object
)