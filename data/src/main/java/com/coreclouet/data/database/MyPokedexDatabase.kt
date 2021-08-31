package com.coreclouet.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coreclouet.data.database.dao.VersionDao
import com.coreclouet.data.database.dao.VersionGroupDao
import com.coreclouet.data.database.model.GenerationEntity
import com.coreclouet.data.database.model.VersionEntity
import com.coreclouet.data.database.model.VersionGroupEntity

@Database(
    entities = [GenerationEntity::class, VersionEntity::class, VersionGroupEntity::class],
    version = 1
)
abstract class MyPokedexDatabase : RoomDatabase() {
    abstract fun versionDao(): VersionDao
    abstract fun versionGroupDao(): VersionGroupDao
}