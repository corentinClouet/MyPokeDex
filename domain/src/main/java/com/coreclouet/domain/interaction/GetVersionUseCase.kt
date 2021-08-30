package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.VersionRepository

class GetVersionUseCase(private val versionRepository: VersionRepository) {
    suspend operator fun invoke(name: String) = versionRepository.getVersion(name)
}