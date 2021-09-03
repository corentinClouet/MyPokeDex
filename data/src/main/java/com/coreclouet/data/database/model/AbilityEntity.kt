package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.ABILITY_TABLE_NAME
import com.coreclouet.domain.model.Ability

@Entity(tableName = ABILITY_TABLE_NAME)
data class AbilityEntity(
    @PrimaryKey
    val abilityId: Int,
    val abilityName: String,
    val generationName: String,
    val description: String,
    val effect: String,
    val shortEffect: String?
) {
    fun mapToDomain(): Ability {
        return Ability(
            id = this.abilityId,
            name = this.abilityName,
            generationName = this.generationName,
            description = this.description,
            effect = this.effect,
            shortEffect = this.shortEffect
        )
    }
}