package com.coreclouet.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coreclouet.data.database.ABILITY_TABLE_NAME
import com.coreclouet.data.database.model.AbilityEntity

@Dao
interface AbilityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAbility(abilityEntity: AbilityEntity)

    @Query("SELECT * FROM $ABILITY_TABLE_NAME")
    suspend fun getAbilities(): List<AbilityEntity>?

    @Query("SELECT * FROM $ABILITY_TABLE_NAME WHERE abilityName=:name")
    suspend fun getAbility(name: String): AbilityEntity?

    @Query("SELECT * FROM $ABILITY_TABLE_NAME WHERE abilityId=:id")
    suspend fun getAbility(id: Int): AbilityEntity?
}