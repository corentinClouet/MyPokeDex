package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class VersionGroupResponse(

	@field:SerializedName("generation")
	val generation: VgGeneration? = null,

	@field:SerializedName("regions")
	val regions: List<VgRegionsItem>? = null,

	@field:SerializedName("pokedexes")
	val pokedexes: List<VgPokedexesItem>? = null,

	@field:SerializedName("versions")
	val versions: List<VgVersionsItem>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("move_learn_methods")
	val moveLearnMethods: List<VgMoveLearnMethodsItem>? = null,

	@field:SerializedName("order")
	val order: Int? = null
)

data class VgRegionsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class VgMoveLearnMethodsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class VgVersionsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class VgPokedexesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class VgGeneration(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
