package com.coreclouet.data.di

import com.coreclouet.data.repositoryimpl.VersionRepositoryImpl
import com.coreclouet.domain.repository.VersionRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<VersionRepository> { VersionRepositoryImpl(get(), get()) }
}