package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.VersionGroupRepository

class GetVersionGroupUseCase(private val versionGroupRepository: VersionGroupRepository) {
    suspend operator fun invoke(name: String) = versionGroupRepository.getVersionGroup(name)
}