package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.GENERATION_TABLE_NAME

@Entity(tableName = GENERATION_TABLE_NAME)
data class GenerationEntity(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val mainRegionName: String?
)
