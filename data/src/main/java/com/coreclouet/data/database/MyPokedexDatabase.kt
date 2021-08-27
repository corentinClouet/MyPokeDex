package com.coreclouet.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coreclouet.data.database.dao.VersionDao
import com.coreclouet.data.database.model.GenerationEntity
import com.coreclouet.data.database.model.VersionEntity

@Database(
    entities = [GenerationEntity::class, VersionEntity::class],
    version = 1
)
abstract class MyPokedexDatabase : RoomDatabase() {
    abstract fun versionDao(): VersionDao
}