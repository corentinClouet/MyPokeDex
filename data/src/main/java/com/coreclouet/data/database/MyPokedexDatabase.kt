package com.coreclouet.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coreclouet.data.database.dao.*
import com.coreclouet.data.database.model.*

@Database(
    entities = [
        AbilityEntity::class,
        GenerationEntity::class,
        MoveEntity::class,
        PokemonAbilityCrossRefEntity::class,
        PokemonEntity::class,
        PokemonMoveCrossRefEntity::class,
        PokemonTypeCrossRefEntity::class,
        StatEntity::class,
        TypeEntity::class,
        VersionEntity::class,
        VersionGroupEntity::class],
    version = 3,
    exportSchema = true
)
abstract class MyPokedexDatabase : RoomDatabase() {
    abstract fun abilityDao(): AbilityDao
    abstract fun generationDao(): GenerationDao
    abstract fun moveDao(): MoveDao
    abstract fun pokemonAbilityCrossRefDao(): PokemonAbilityCrossRefDao
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonMoveCrossRefDao(): PokemonMoveCrossRefDao
    abstract fun pokemonTypeCrossRefDao(): PokemonTypeCrossRefDao
    abstract fun statDao(): StatDao
    abstract fun typeDao(): TypeDao
    abstract fun versionDao(): VersionDao
    abstract fun versionGroupDao(): VersionGroupDao

}
