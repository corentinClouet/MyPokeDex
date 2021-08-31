package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Generation

interface GenerationRepository {
    suspend fun getGenerationsList(): List<Generation>?
    suspend fun getGenerationsNamesList(): List<String>?
    suspend fun getGeneration(name: String): Generation?
}