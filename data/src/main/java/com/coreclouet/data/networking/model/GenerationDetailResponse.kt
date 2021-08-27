package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class GenerationDetailResponse(

	@field:SerializedName("abilities")
	val abilities: List<Any>? = null,

	@field:SerializedName("types")
	val types: List<GenerationTypesItem>? = null,

	@field:SerializedName("names")
	val names: List<NamesItem>? = null,

	@field:SerializedName("main_region")
	val mainRegion: MainRegion? = null,

	@field:SerializedName("version_groups")
	val versionGroups: List<VersionGroupsItem>? = null,

	@field:SerializedName("moves")
	val moves: List<GenerationMovesItem>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("pokemon_species")
	val pokemonSpecies: List<PokemonSpeciesItem>? = null
)

data class MainRegion(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class VersionGroupsItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class GenerationTypesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class GenerationMovesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class PokemonSpeciesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
