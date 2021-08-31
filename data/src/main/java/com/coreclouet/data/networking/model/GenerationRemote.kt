package com.coreclouet.data.networking.model

import com.coreclouet.data.database.model.GenerationEntity
import com.google.gson.annotations.SerializedName

data class GenerationRemote(

	@field:SerializedName("abilities")
	val abilities: List<Any>? = null,

	@field:SerializedName("types")
	val types: List<GenerationTypesItem>? = null,

	@field:SerializedName("names")
	val names: List<NamesItem>? = null,

	@field:SerializedName("main_region")
	val mainRegion: MainRegion,

	@field:SerializedName("version_groups")
	val versionGroups: List<VersionGroupsItem>? = null,

	@field:SerializedName("moves")
	val moves: List<GenerationMovesItem>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("pokemon_species")
	val pokemonSpecies: List<PokemonSpeciesItem>? = null
) {
	fun mapToRoomEntity(): GenerationEntity {
		return GenerationEntity(
			id = this.id,
			name = this.name,
			mainRegionName = this.mainRegion.name
		)
	}
}

data class MainRegion(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VersionGroupsItem(

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

data class PokemonSpeciesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
