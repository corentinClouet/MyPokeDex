package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Ability

interface AbilityRepository {
    suspend fun getAbilityFromPokemon(abilityName: String, pokemonOwnerId: Int): Ability?
    suspend fun getAbility(abilityId: Int): Ability?
    suspend fun getAbility(abilityName: String): Ability?
}