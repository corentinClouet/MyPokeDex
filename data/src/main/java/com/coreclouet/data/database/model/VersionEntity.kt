package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.VERSION_TABLE_NAME
import com.coreclouet.domain.model.Version

@Entity(tableName = VERSION_TABLE_NAME)
data class VersionEntity(
    @PrimaryKey
    val versionId: Int,
    val versionName: String,
    val versionGroupName: String
) {
    fun mapToDomain(): Version {
        return Version(
            id = this.versionId,
            name = this.versionName,
            versionGroupName = this.versionGroupName
        )
    }
}