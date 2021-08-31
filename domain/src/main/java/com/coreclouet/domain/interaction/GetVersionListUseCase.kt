package com.coreclouet.domain.interaction

import com.coreclouet.domain.model.Version
import com.coreclouet.domain.repository.VersionRepository

class GetVersionListUseCase(private val versionRepository: VersionRepository) {

    suspend operator fun invoke(): List<Version>? = versionRepository.getVersionsList()

}