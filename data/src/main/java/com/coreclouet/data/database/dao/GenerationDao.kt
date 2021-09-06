package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.GENERATION_TABLE_NAME
import com.coreclouet.data.database.model.GenerationEntity

@Dao
interface GenerationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGeneration(generationEntity: GenerationEntity)

    @Query("SELECT * FROM $GENERATION_TABLE_NAME")
    suspend fun getGenerations(): List<GenerationEntity>?

    @Query("SELECT generationName FROM $GENERATION_TABLE_NAME")
    suspend fun getGenerationsNames(): List<String>?

    @Query("SELECT * FROM $GENERATION_TABLE_NAME WHERE generationName=:name")
    suspend fun getGeneration(name: String): GenerationEntity?

    @Query("SELECT * FROM $GENERATION_TABLE_NAME WHERE generationId=:id")
    suspend fun getGeneration(id: Long): GenerationEntity?
}