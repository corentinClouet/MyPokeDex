package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesRemote(

	@field:SerializedName("evolution_chain")
	val evolutionChain: PsEvolutionChain? = null,

	@field:SerializedName("genera")
	val genera: List<PsGeneraItem>? = null,

	@field:SerializedName("habitat")
	val habitat: PsHabitat? = null,

	@field:SerializedName("color")
	val color: PsColor? = null,

	@field:SerializedName("egg_groups")
	val eggGroups: List<PsEggGroupsItem>? = null,

	@field:SerializedName("capture_rate")
	val captureRate: Int? = null,

	@field:SerializedName("pokedex_numbers")
	val pokedexNumbers: List<PsPokedexNumbersItem>? = null,

	@field:SerializedName("forms_switchable")
	val formsSwitchable: Boolean? = null,

	@field:SerializedName("growth_rate")
	val growthRate: PsGrowthRate? = null,

	@field:SerializedName("flavor_text_entries")
	val flavorTextEntries: List<PsFlavorTextEntriesItem>? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("is_baby")
	val isBaby: Boolean,

	@field:SerializedName("order")
	val order: Int,

	@field:SerializedName("generation")
	val generation: PsGeneration? = null,

	@field:SerializedName("is_legendary")
	val isLegendary: Boolean,

	@field:SerializedName("pal_park_encounters")
	val palParkEncounters: List<PsPalParkEncountersItem>? = null,

	@field:SerializedName("shape")
	val shape: PsShape? = null,

	@field:SerializedName("is_mythical")
	val isMythical: Boolean? = null,

	@field:SerializedName("base_happiness")
	val baseHappiness: Int? = null,

	@field:SerializedName("names")
	val names: List<PsNamesItem>? = null,

	@field:SerializedName("varieties")
	val varieties: List<PsVarietiesItem>? = null,

	@field:SerializedName("gender_rate")
	val genderRate: Int? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("has_gender_differences")
	val hasGenderDifferences: Boolean,

	@field:SerializedName("hatch_counter")
	val hatchCounter: Int? = null,

	@field:SerializedName("form_descriptions")
	val formDescriptions: List<Any?>? = null,

	@field:SerializedName("evolves_from_species")
	val evolvesFromSpecies: Any? = null
)

data class PsHabitat(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsPokedex(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsGrowthRate(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsGeneration(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsArea(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsVarietiesItem(

	@field:SerializedName("pokemon")
	val pokemon: PsPokemon? = null,

	@field:SerializedName("is_default")
	val isDefault: Boolean? = null
)

data class PsPokedexNumbersItem(

	@field:SerializedName("entry_number")
	val entryNumber: Int? = null,

	@field:SerializedName("pokedex")
	val pokedex: PsPokedex? = null
)

data class PsNamesItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("language")
	val language: PsLanguage? = null
)

data class PsGeneraItem(

	@field:SerializedName("genus")
	val genus: String? = null,

	@field:SerializedName("language")
	val language: PsLanguage? = null
)

data class PsPokemon(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsFlavorTextEntriesItem(

	@field:SerializedName("language")
	val language: PsLanguage? = null,

	@field:SerializedName("version")
	val version: PsVersion? = null,

	@field:SerializedName("flavor_text")
	val flavorText: String? = null
)

data class PsPalParkEncountersItem(

	@field:SerializedName("area")
	val area: PsArea? = null,

	@field:SerializedName("base_score")
	val baseScore: Int? = null,

	@field:SerializedName("rate")
	val rate: Int? = null
)

data class PsEvolutionChain(

	@field:SerializedName("url")
	val url: String? = null
)

data class PsShape(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsColor(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsLanguage(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsEggGroupsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PsVersion(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
