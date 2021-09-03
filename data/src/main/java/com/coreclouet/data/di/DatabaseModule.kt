package com.coreclouet.data.di

import androidx.room.Room
import com.coreclouet.data.database.DATABASE_NAME
import com.coreclouet.data.database.MyPokedexDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        //TODO remove fallbackToDestructiveMigration when this goes to production
        Room.databaseBuilder(androidContext(), MyPokedexDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration().build()
    }
    factory { get<MyPokedexDatabase>().abilityDao() }
    factory { get<MyPokedexDatabase>().generationDao() }
    factory { get<MyPokedexDatabase>().moveDao() }
    factory { get<MyPokedexDatabase>().pokemonAbilityCrossRefDao() }
    factory { get<MyPokedexDatabase>().pokemonDao() }
    factory { get<MyPokedexDatabase>().pokemonMoveCrossRefDao() }
    factory { get<MyPokedexDatabase>().pokemonTypeCrossRefDao() }
    factory { get<MyPokedexDatabase>().statDao() }
    factory { get<MyPokedexDatabase>().typeDao() }
    factory { get<MyPokedexDatabase>().versionDao() }
    factory { get<MyPokedexDatabase>().versionGroupDao() }

}