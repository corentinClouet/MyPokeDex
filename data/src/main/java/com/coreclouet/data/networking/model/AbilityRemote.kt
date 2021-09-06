package com.coreclouet.data.networking.model

import com.coreclouet.data.database.ENGLISH_LANGUAGE
import com.coreclouet.data.database.model.AbilityEntity
import com.google.gson.annotations.SerializedName

data class AbilityRemote(

	@field:SerializedName("effect_entries")
	val effectEntries: List<AbEffectEntriesItem>,

	@field:SerializedName("generation")
	val generation: AbGeneration,

	@field:SerializedName("is_main_series")
	val isMainSeries: Boolean,

	@field:SerializedName("names")
	val names: List<AbNamesItem>? = null,

	@field:SerializedName("pokemon")
	val pokemon: List<AbPokemonItem>? = null,

	@field:SerializedName("flavor_text_entries")
	val flavorTextEntries: List<AbFlavorTextEntriesItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("effect_changes")
	val effectChanges: List<Any>? = null
) {
	fun mapToRoomEntity(): AbilityEntity {
		return AbilityEntity(
			abilityId = this.id,
			abilityName = this.name,
			generationName = this.generation.name,
			description = this.flavorTextEntries.filter { it.language.name == ENGLISH_LANGUAGE }[0].flavorText, //TODO manage language later
			effect = this.effectEntries.filter { it.language.name == ENGLISH_LANGUAGE }[0].effect, //TODO manage language later
			shortEffect = this.effectEntries.filter { it.language.name == ENGLISH_LANGUAGE }[0].shortEffect //TODO manage language later
		)
	}
}

data class AbPokemonItem(

	@field:SerializedName("pokemon")
	val pokemon: AbPokemon,

	@field:SerializedName("is_hidden")
	val isHidden: Boolean,

	@field:SerializedName("slot")
	val slot: Int
)

data class AbEffectEntriesItem(

	@field:SerializedName("short_effect")
	val shortEffect: String,

	@field:SerializedName("effect")
	val effect: String,

	@field:SerializedName("language")
	val language: AbLanguage
)

data class AbLanguage(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AbNamesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("language")
	val language: AbLanguage
)

data class AbPokemon(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AbFlavorTextEntriesItem(

	@field:SerializedName("version_group")
	val versionGroup: AbVersionGroup,

	@field:SerializedName("language")
	val language: AbLanguage,

	@field:SerializedName("flavor_text")
	val flavorText: String
)

data class AbGeneration(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class AbVersionGroup(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
