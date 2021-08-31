package com.coreclouet.domain.repository

import com.coreclouet.domain.model.VersionGroup

interface VersionGroupRepository {
    suspend fun getVersionGroup(name: String): VersionGroup?
}