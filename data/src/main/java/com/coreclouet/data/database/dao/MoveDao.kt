package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.MOVE_TABLE_NAME
import com.coreclouet.data.database.model.MoveEntity

@Dao
interface MoveDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMove(moveEntity: MoveEntity)

    @Query("SELECT * FROM $MOVE_TABLE_NAME")
    suspend fun getMoves(): List<MoveEntity>?

    @Query("SELECT * FROM $MOVE_TABLE_NAME WHERE moveName=:name")
    suspend fun getMove(name: String): MoveEntity?

    @Query("SELECT * FROM $MOVE_TABLE_NAME WHERE moveId=:id")
    suspend fun getMove(id: Int): MoveEntity?
}