package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.TYPE_TABLE_NAME
import com.coreclouet.data.database.model.TypeEntity

@Dao
interface TypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertType(typeEntity: TypeEntity)

    @Query("SELECT * FROM $TYPE_TABLE_NAME")
    suspend fun getTypes(): List<TypeEntity>?

    @Query("SELECT * FROM $TYPE_TABLE_NAME WHERE typeId=:typeId")
    suspend fun getType(typeId: Int): TypeEntity?

    @Query("SELECT * FROM $TYPE_TABLE_NAME WHERE typeName=:typeName")
    suspend fun getType(typeName: String): TypeEntity?
}