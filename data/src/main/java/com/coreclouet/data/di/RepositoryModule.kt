package com.coreclouet.data.di

import com.coreclouet.data.repositoryimpl.*
import com.coreclouet.domain.repository.*
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
    factory<AbilityRepository> {
        AbilityRepositoryImpl(
            apiService = get(),
            abilityDao = get(),
            pokemonAbilityCrossRefDao = get()
        )
    }
    factory<PokemonRepository> {
        PokemonRepositoryImpl(
            apiService = get(),
            pokemonDao = get(),
            abilityRepository = get(),
            typeRepository = get()
        )
    }
    factory<TypeRepository> {
        TypeRepositoryImpl(
            apiService = get(),
            typeDao = get(),
            pokemonTypeCrossRefDao = get()
        )
    }

}