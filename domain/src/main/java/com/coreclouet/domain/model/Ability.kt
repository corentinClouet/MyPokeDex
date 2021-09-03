package com.coreclouet.domain.model

data class Ability(
    val id: Int,
    val name: String,
    val generationName: String,
    val description: String,
    val effect: String,
    val shortEffect: String?
)