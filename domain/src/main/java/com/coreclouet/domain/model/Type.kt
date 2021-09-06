package com.coreclouet.domain.model

data class Type(
    val id: Int,
    val name: String,
    val generationName: String,
    val moveDamageClassName: String?,
    val doubleDamageFrom: List<String>?,
    val doubleDamageTo: List<String>?,
    val halfDamageFrom: List<String>?,
    val halfDamageTo: List<String>?,
    val noDamageFrom: List<String>?,
    val noDamageTo: List<String>?,
)