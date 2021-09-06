package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.DELIMITER
import com.coreclouet.data.database.TYPE_TABLE_NAME
import com.coreclouet.domain.model.Type

@Entity(tableName = TYPE_TABLE_NAME)
data class TypeEntity(
    @PrimaryKey
    val typeId: Int,
    val typeName: String,
    val generationName: String,
    val moveDamageClassName: String?,
    val doubleDamageFrom: String?,
    val doubleDamageTo: String?,
    val halfDamageFrom: String?,
    val halfDamageTo: String?,
    val noDamageFrom: String?,
    val noDamageTo: String?,
) {
    fun mapToDomain(): Type {
        return Type(
            id = typeId,
            name = typeName,
            generationName = generationName,
            moveDamageClassName = moveDamageClassName,
            doubleDamageFrom = doubleDamageFrom?.split(DELIMITER),
            doubleDamageTo = doubleDamageTo?.split(DELIMITER),
            halfDamageFrom = halfDamageFrom?.split(DELIMITER),
            halfDamageTo = halfDamageTo?.split(DELIMITER),
            noDamageFrom = noDamageFrom?.split(DELIMITER),
            noDamageTo = noDamageTo?.split(DELIMITER)
        )
    }
}