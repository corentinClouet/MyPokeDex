package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.GenerationRepository

class GetGenerationUseCase(private val generationRepository: GenerationRepository) {
    suspend operator fun invoke(name: String) = generationRepository.getGeneration(name)
}