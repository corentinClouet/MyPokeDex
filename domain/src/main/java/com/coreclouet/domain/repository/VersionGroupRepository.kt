package com.coreclouet.domain.repository

import com.coreclouet.domain.model.VersionGroup

interface VersionGroupRepository {
    suspend fun getVersionGroupList(): List<VersionGroup>?
    suspend fun getVersionGroupNamesList(): List<String>?
    suspend fun getVersionGroup(name: String): VersionGroup?
}