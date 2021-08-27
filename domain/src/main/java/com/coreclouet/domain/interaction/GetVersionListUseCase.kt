package com.coreclouet.domain.interaction

import com.coreclouet.domain.repository.VersionRepository

class GetVersionListUseCase(private val versionRepository: VersionRepository) {

    suspend operator fun invoke(): List<String>? = versionRepository.getVersionList()

}