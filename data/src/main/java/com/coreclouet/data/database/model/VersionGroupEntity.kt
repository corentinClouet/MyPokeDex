package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.VERSION_GROUP_TABLE_NAME
import com.coreclouet.domain.model.VersionGroup

@Entity(tableName = VERSION_GROUP_TABLE_NAME)
data class VersionGroupEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val order: Int,
    val generationName: String
) {
    fun mapToDomain(): VersionGroup {
        return VersionGroup(
            id = this.id,
            name = this.name,
            order = this.order,
            generationName = this.generationName
        )
    }
}