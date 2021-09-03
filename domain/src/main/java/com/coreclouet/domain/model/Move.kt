package com.coreclouet.domain.model

data class Move(
    val id: Int,
    val name: String,
    val accuracy: Int,
    val contestTypeName: String,
    val damageClassName: String,
    val effectEntries: List<MoveEffectEntry>?,
    val flavorTextEntries: List<MoveFlavorTextEntry>?,
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
)
