package com.coreclouet.data.networking.model

import com.coreclouet.data.database.model.VersionGroupEntity
import com.google.gson.annotations.SerializedName

data class VersionGroupResponse(

	@field:SerializedName("generation")
	val generation: VgGeneration,

	@field:SerializedName("regions")
	val regions: List<VgRegionsItem>? = null,

	@field:SerializedName("pokedexes")
	val pokedexes: List<VgPokedexesItem>? = null,

	@field:SerializedName("versions")
	val versions: List<VgVersionsItem>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("move_learn_methods")
	val moveLearnMethods: List<VgMoveLearnMethodsItem>? = null,

	@field:SerializedName("order")
	val order: Int
) {
	fun mapToRoomEntity(): VersionGroupEntity {
		return VersionGroupEntity(
			id = this.id,
			name = this.name,
			order = this.order,
			generationName = this.generation.name
		)
	}
}

data class VgRegionsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VgMoveLearnMethodsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VgVersionsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VgPokedexesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VgGeneration(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
