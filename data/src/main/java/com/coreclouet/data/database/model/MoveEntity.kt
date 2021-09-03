package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.MOVE_TABLE_NAME
import com.coreclouet.domain.model.Move

@Entity(tableName = MOVE_TABLE_NAME)
data class MoveEntity(
    @PrimaryKey
    val moveId: Int,
    val moveName: String,
    val accuracy: Int,
    val contestTypeName: String,
    val damageClassName: String,
    val generationName: String,
    val power: Int,
    val pp: Int,
    val targetName: String,
    val typeName: String,
    val ailmentName: String,
    val ailmentChance: Int,
    val category: String,
    val criticalRate: Int,
    val drain: Int,
    val flinchChance: Int,
    val healing: Int,
    val statChance: Int
) {
    fun mapToDomain(): Move {
        return Move(
            id = this.moveId,
            name = this.moveName,
            accuracy = this.accuracy,
            contestTypeName = this.contestTypeName,
            damageClassName = this.damageClassName,
            effectEntries = null, //TODO fill effectEntries
            flavorTextEntries = null, //TODO fill flavorTextEntries
            generationName = this.generationName,
            power = this.power,
            pp = this.pp,
            targetName = this.targetName,
            typeName = this.typeName,
            ailmentName = this.ailmentName,
            ailmentChance = this.ailmentChance,
            category = this.category,
            criticalRate = this.criticalRate,
            drain = this.drain,
            flinchChance = this.flinchChance,
            healing = this.healing,
            statChance = this.statChance
        )
    }
}