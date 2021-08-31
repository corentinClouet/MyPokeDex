package com.coreclouet.domain.interaction

import com.coreclouet.domain.model.VersionGroup
import com.coreclouet.domain.repository.VersionGroupRepository

class GetVersionGroupListUseCase(private val versionGroupRepository: VersionGroupRepository) {

    suspend operator fun invoke(): List<VersionGroup>? =
        versionGroupRepository.getVersionGroupList()

}