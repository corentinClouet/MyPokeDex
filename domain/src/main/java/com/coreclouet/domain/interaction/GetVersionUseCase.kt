package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.VersionRepository

class GetVersionUseCase(private val versionRepository: VersionRepository) {
    suspend operator fun invoke(name: String) = versionRepository.getVersion(name)
    suspend operator fun invoke(id: Long) = versionRepository.getVersion(id)
}