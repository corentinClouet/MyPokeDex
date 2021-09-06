package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.VERSION_TABLE_NAME
import com.coreclouet.data.database.model.VersionEntity

@Dao
interface VersionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVersion(version: VersionEntity)

    @Query("SELECT * FROM $VERSION_TABLE_NAME")
    suspend fun getVersions(): List<VersionEntity>?

    @Query("SELECT versionName FROM $VERSION_TABLE_NAME")
    suspend fun getVersionsNames(): List<String>?

    @Query("SELECT * FROM $VERSION_TABLE_NAME WHERE versionName=:name")
    suspend fun getVersion(name: String): VersionEntity?

    @Query("SELECT * FROM $VERSION_TABLE_NAME WHERE versionId=:id")
    suspend fun getVersion(id: Long): VersionEntity?
}