package com.coreclouet.data.di

import com.coreclouet.data.repositoryimpl.GenerationRepositoryImpl
import com.coreclouet.data.repositoryimpl.VersionGroupRepositoryImpl
import com.coreclouet.data.repositoryimpl.VersionRepositoryImpl
import com.coreclouet.domain.repository.GenerationRepository
import com.coreclouet.domain.repository.VersionGroupRepository
import com.coreclouet.domain.repository.VersionRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<GenerationRepository> {
        GenerationRepositoryImpl(
            apiService = get(),
            generationDao = get(),
            versionGroupRepository = get()
        )
    }
    factory<VersionGroupRepository> {
        VersionGroupRepositoryImpl(
            apiService = get(),
            versionGroupDao = get(),
            versionRepository = get()
        )
    }
    factory<VersionRepository> { VersionRepositoryImpl(apiService = get(), versionDao = get()) }
}