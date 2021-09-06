package com.coreclouet.data.networking.model

import com.coreclouet.data.database.model.GenerationEntity
import com.google.gson.annotations.SerializedName

data class GenerationRemote(

	@field:SerializedName("abilities")
	val abilities: List<Any>? = null,

	@field:SerializedName("types")
	val types: List<GenerationTypesItem>? = null,

	@field:SerializedName("names")
	val names: List<GenerationNamesItem>? = null,

	@field:SerializedName("main_region")
	val mainRegion: GenerationMainRegion,

	@field:SerializedName("version_groups")
	val versionGroups: List<GenerationVersionGroupsItem>? = null,

	@field:SerializedName("moves")
	val moves: List<GenerationMovesItem>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("pokemon_species")
	val pokemonSpecies: List<GenerationPokemonSpeciesItem>? = null
) {
	fun mapToRoomEntity(): GenerationEntity {
		return GenerationEntity(
			generationId = this.id,
			generationName = this.name,
			mainRegionName = this.mainRegion.name
		)
	}
}

data class GenerationMainRegion(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenerationVersionGroupsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenerationTypesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenerationMovesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenerationPokemonSpeciesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class GenerationNamesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("language")
	val language: AbLanguage
)
