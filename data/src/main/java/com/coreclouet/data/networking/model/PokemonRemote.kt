package com.coreclouet.data.networking.model

import com.coreclouet.data.database.UNKN0WN_DESCRIPTION
import com.coreclouet.data.database.model.PokemonEntity
import com.google.gson.annotations.SerializedName

data class PokemonRemote(

	@field:SerializedName("location_area_encounters")
	val locationAreaEncounters: String,

	@field:SerializedName("types")
	val types: List<PkTypesItem>,

	@field:SerializedName("base_experience")
	val baseExperience: Int,

	@field:SerializedName("held_items")
	val heldItems: List<Any?>? = null,

	@field:SerializedName("weight")
	val weight: Int,

	@field:SerializedName("is_default")
	val isDefault: Boolean,

	@field:SerializedName("past_types")
	val pastTypes: List<Any?>? = null,

	@field:SerializedName("sprites")
	val sprites: PkSprites,

	@field:SerializedName("abilities")
	val abilities: List<PkAbilitiesItem>? = null,

	@field:SerializedName("game_indices")
	val gameIndices: List<PkGameIndicesItem>? = null,

	@field:SerializedName("species")
	val species: PkSpecies,

	@field:SerializedName("stats")
	val stats: List<PkStatsItem>? = null,

	@field:SerializedName("moves")
	val moves: List<PkMovesItem>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("forms")
	val forms: List<PkFormsItem>? = null,

	@field:SerializedName("height")
	val height: Int,

	@field:SerializedName("order")
	val order: Int
) {
	fun mapToRoomEntity(pokemonSpeciesRemote: PokemonSpeciesRemote): PokemonEntity {
		return PokemonEntity(
			pokemonId = this.id,
			pokemonName = this.name,
			baseXp = this.baseExperience,
			height = this.height,
			order = this.order,
			defaultSprite = this.sprites.frontDefault,
			officialSprite = this.sprites.other.officialArtwork.frontDefault,
			weight = this.weight,
			captureRate = pokemonSpeciesRemote.captureRate,
			description = pokemonSpeciesRemote.flavorTextEntries?.get(0)?.flavorText ?: UNKN0WN_DESCRIPTION,
			genderRate =  pokemonSpeciesRemote.genderRate,
			generationName = pokemonSpeciesRemote.generation.name,
			growthRateName = pokemonSpeciesRemote.growthRate.name,
			habitatName = pokemonSpeciesRemote.habitat.name,
			genderDifference =  pokemonSpeciesRemote.hasGenderDifferences,
			isBaby = pokemonSpeciesRemote.isBaby,
			isLegendary = pokemonSpeciesRemote.isLegendary,
			isMythical = pokemonSpeciesRemote.isMythical,
			shapeName = pokemonSpeciesRemote.shape.name
		)
	}
}

data class PkMove(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkDreamWorld(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null
)

data class PkOther(

	@field:SerializedName("dream_world")
	val dreamWorld: PkDreamWorld? = null,

	@field:SerializedName("official-artwork")
	val officialArtwork: PkOfficialArtwork
)

data class PkHeartgoldSoulsilver(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkBlackWhite(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("animated")
	val animated: PkAnimated? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkVersionGroupDetailsItem(

	@field:SerializedName("level_learned_at")
	val levelLearnedAt: Int? = null,

	@field:SerializedName("version_group")
	val versionGroup: PkPokemonVersionGroup? = null,

	@field:SerializedName("move_learn_method")
	val moveLearnMethod: PkMoveLearnMethod? = null
)

data class PkGenerationIv(

	@field:SerializedName("platinum")
	val platinum: PkPlatinum? = null,

	@field:SerializedName("diamond-pearl")
	val diamondPearl: PkDiamondPearl? = null,

	@field:SerializedName("heartgold-soulsilver")
	val heartgoldSoulsilver: PkHeartgoldSoulsilver? = null
)

data class PkGenerationI(

	@field:SerializedName("yellow")
	val yellow: PkYellow? = null,

	@field:SerializedName("red-blue")
	val redBlue: PkRedBlue? = null
)

data class PkTypesItem(

	@field:SerializedName("slot")
	val slot: Int,

	@field:SerializedName("type")
	val type: PkType
)

data class PkFormsItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkMoveLearnMethod(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkVersions(

	@field:SerializedName("generation-iii")
	val generationIii: PkGenerationIii? = null,

	@field:SerializedName("generation-ii")
	val generationIi: PkGenerationIi? = null,

	@field:SerializedName("generation-v")
	val generationV: PkGenerationV? = null,

	@field:SerializedName("generation-iv")
	val generationIv: PkGenerationIv? = null,

	@field:SerializedName("generation-vii")
	val generationVii: PkGenerationVii? = null,

	@field:SerializedName("generation-i")
	val generationI: PkGenerationI? = null,

	@field:SerializedName("generation-viii")
	val generationViii: PkGenerationViii? = null,

	@field:SerializedName("generation-vi")
	val generationVi: PkGenerationVi? = null
)

data class PkGenerationV(

	@field:SerializedName("black-white")
	val blackWhite: PkBlackWhite? = null
)

data class PkRedBlue(

	@field:SerializedName("front_gray")
	val frontGray: String? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("back_gray")
	val backGray: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null
)

data class PkXY(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkGold(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkAnimated(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkGenerationVii(

	@field:SerializedName("icons")
	val icons: PkIcons? = null,

	@field:SerializedName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: PkUltraSunUltraMoon? = null
)

data class PkUltraSunUltraMoon(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkAbility(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkGenerationIi(

	@field:SerializedName("gold")
	val gold: PkGold? = null,

	@field:SerializedName("crystal")
	val crystal: PkCrystal? = null,

	@field:SerializedName("silver")
	val silver: PkSilver? = null
)

data class PkVersion(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkGameIndicesItem(

	@field:SerializedName("game_index")
	val gameIndex: Int,

	@field:SerializedName("version")
	val version: PkVersion
)

data class PkGenerationViii(

	@field:SerializedName("icons")
	val icons: PkIcons? = null
)

data class PkPokemonVersionGroup(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkSpecies(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkAbilitiesItem(

	@field:SerializedName("is_hidden")
	val isHidden: Boolean,

	@field:SerializedName("ability")
	val ability: PkAbility,

	@field:SerializedName("slot")
	val slot: Int
)

data class PkSilver(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkStat(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkGenerationIii(

	@field:SerializedName("firered-leafgreen")
	val fireredLeafgreen: PkFireredLeafgreen? = null,

	@field:SerializedName("ruby-sapphire")
	val rubySapphire: PkRubySapphire? = null,

	@field:SerializedName("emerald")
	val emerald: PkEmerald? = null
)

data class PkOfficialArtwork(

	@field:SerializedName("front_default")
	val frontDefault: String
)

data class PkFireredLeafgreen(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkEmerald(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkStatsItem(

	@field:SerializedName("stat")
	val stat: PkStat,

	@field:SerializedName("base_stat")
	val baseStat: Int,

	@field:SerializedName("effort")
	val effort: Int
)

data class PkOmegarubyAlphasapphire(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkDiamondPearl(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkPlatinum(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkType(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class PkGenerationVi(

	@field:SerializedName("omegaruby-alphasapphire")
	val omegarubyAlphasapphire: PkOmegarubyAlphasapphire? = null,

	@field:SerializedName("x-y")
	val xY: PkXY? = null
)

data class PkMovesItem(

	@field:SerializedName("version_group_details")
	val versionGroupDetails: List<PkVersionGroupDetailsItem>,

	@field:SerializedName("move")
	val move: PkMove
)

data class PkSprites(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("other")
	val other: PkOther,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String,

	@field:SerializedName("versions")
	val versions: PkVersions? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkYellow(

	@field:SerializedName("front_gray")
	val frontGray: String? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("back_gray")
	val backGray: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null
)

data class PkCrystal(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkRubySapphire(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class PkIcons(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null
)
