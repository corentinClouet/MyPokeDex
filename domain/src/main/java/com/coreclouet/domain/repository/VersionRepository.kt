package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Version

interface VersionRepository {
    suspend fun getVersionList(): List<String>?
    suspend fun getVersion(name: String): Version?
    suspend fun getVersion(id: Long): Version?
}