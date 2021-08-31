package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.GenerationRepository

class GetGenerationListUseCase(private val generationRepository: GenerationRepository) {
    suspend operator fun invoke() = generationRepository.getGenerationsList()
}