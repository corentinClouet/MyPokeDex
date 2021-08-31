package com.coreclouet.domain.repository

import com.coreclouet.domain.model.Version

interface VersionRepository {
    suspend fun getVersionsNamesList(): List<String>?
    suspend fun getVersionsList(): List<Version>?
    suspend fun getVersion(name: String): Version?
}