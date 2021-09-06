package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Stat

interface StatRepository {
    suspend fun insertStat(stat: Stat)
    suspend fun getStat(pokemonOwnerId: Int): Stat?
}