package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.STAT_TABLE_NAME
import com.coreclouet.data.database.model.StatEntity

@Dao
interface StatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStat(statEntity: StatEntity)

    @Query("SELECT * FROM $STAT_TABLE_NAME")
    suspend fun getStats(): List<StatEntity>?

    @Query("SELECT * FROM $STAT_TABLE_NAME WHERE pokemonOwnerId=:pokemonOwnerId")
    suspend fun getStat(pokemonOwnerId: Int): StatEntity?
}