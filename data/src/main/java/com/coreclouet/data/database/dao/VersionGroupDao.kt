package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.VERSION_GROUP_TABLE_NAME
import com.coreclouet.data.database.VERSION_TABLE_NAME
import com.coreclouet.data.database.model.VersionGroupEntity

@Dao
interface VersionGroupDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVersionGroup(versionGroupEntity: VersionGroupEntity)

    @Query("SELECT versionGroupName FROM $VERSION_GROUP_TABLE_NAME")
    suspend fun getVersionsGroupsNames(): List<String>?

    @Query("SELECT * FROM $VERSION_GROUP_TABLE_NAME")
    suspend fun getVersionsGroups(): List<VersionGroupEntity>?

    @Query("SELECT * FROM $VERSION_GROUP_TABLE_NAME WHERE versionGroupName=:name")
    suspend fun getVersionGroup(name: String): VersionGroupEntity?

}