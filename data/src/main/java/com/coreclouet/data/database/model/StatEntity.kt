package com.coreclouet.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.coreclouet.data.database.STAT_TABLE_NAME
import com.coreclouet.domain.model.Stat

@Entity(tableName = STAT_TABLE_NAME)
data class StatEntity(
    @PrimaryKey
    val pokemonOwnerId: Int,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speAttack: Int,
    val speDefense: Int,
    val speed: Int
) {
    fun mapToDomain(): Stat {
        return Stat(
            pokemonOwnerId = this.pokemonOwnerId,
            hp = this.hp,
            attack = this.attack,
            defense = this.defense,
            speAttack = this.speAttack,
            speDefense = this.speDefense,
            speed = this.speed
        )
    }
}