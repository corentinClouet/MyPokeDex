package com.coreclouet.data.networking.model

import com.coreclouet.data.database.model.MoveEntity
import com.google.gson.annotations.SerializedName

data class MoveRemote(

	@field:SerializedName("generation")
	val generation: MvGeneration,

	@field:SerializedName("pp")
	val pp: Int,

	@field:SerializedName("stat_changes")
	val statChanges: List<Any>? = null,

	@field:SerializedName("accuracy")
	val accuracy: Int,

	@field:SerializedName("contest_combos")
	val contestCombos: Any? = null,

	@field:SerializedName("priority")
	val priority: Int,

	@field:SerializedName("super_contest_effect")
	val superContestEffect: MvSuperContestEffect? = null,

	@field:SerializedName("type")
	val type: MvType,

	@field:SerializedName("effect_changes")
	val effectChanges: List<Any>? = null,

	@field:SerializedName("learned_by_pokemon")
	val learnedByPokemon: List<MvLearnedByPokemonItem>? = null,

	@field:SerializedName("target")
	val target: MvTarget,

	@field:SerializedName("effect_entries")
	val effectEntries: List<MvEffectEntriesItem>? = null,

	@field:SerializedName("contest_type")
	val contestType: MvContestType?,

	@field:SerializedName("past_values")
	val pastValues: List<MvPastValuesItem>? = null,

	@field:SerializedName("names")
	val names: List<MvNamesItem>? = null,

	@field:SerializedName("meta")
	val meta: MvMeta,

	@field:SerializedName("flavor_text_entries")
	val flavorTextEntries: List<MvFlavorTextEntriesItem>? = null,

	@field:SerializedName("damage_class")
	val damageClass: MvDamageClass,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("effect_chance")
	val effectChance: Any? = null,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("machines")
	val machines: List<MvMachinesItem>? = null,

	@field:SerializedName("power")
	val power: Int,

	@field:SerializedName("contest_effect")
	val contestEffect: MvContestEffect? = null
) {
	fun mapToRoomEntity(): MoveEntity {
		return MoveEntity(
			moveId = this.id,
			moveName = this.name,
			accuracy = this.accuracy,
			contestTypeName = this.contestType?.name,
			damageClassName = this.damageClass.name,
			generationName = this.generation.name,
			power = this.power,
			pp = this.pp,
			targetName = this.target.name,
			typeName = this.type.name,
			ailmentName = this.meta.ailment.name,
			ailmentChance = this.meta.ailmentChance,
			category = this.meta.category.name,
			criticalRate = this.meta.critRate,
			drain = this.meta.drain,
			flinchChance = this.meta.flinchChance,
			healing = this.meta.healing,
			statChance = this.meta.statChance
		)
	}
}

data class MvEffectEntriesItem(

	@field:SerializedName("short_effect")
	val shortEffect: String? = null,

	@field:SerializedName("effect")
	val effect: String,

	@field:SerializedName("language")
	val language: MvLanguage? = null
)

data class MvTarget(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvLanguage(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvDamageClass(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvPastValuesItem(

	@field:SerializedName("effect_entries")
	val effectEntries: List<Any?>? = null,

	@field:SerializedName("pp")
	val pp: Any? = null,

	@field:SerializedName("version_group")
	val versionGroup: MvVersionGroup? = null,

	@field:SerializedName("accuracy")
	val accuracy: Int? = null,

	@field:SerializedName("effect_chance")
	val effectChance: Any? = null,

	@field:SerializedName("power")
	val power: Any? = null,

	@field:SerializedName("type")
	val type: Any? = null
)

data class MvMachinesItem(

	@field:SerializedName("machine")
	val machine: MvMachine? = null,

	@field:SerializedName("version_group")
	val versionGroup: MvVersionGroup
)

data class MvFlavorTextEntriesItem(

	@field:SerializedName("version_group")
	val versionGroup: MvVersionGroup? = null,

	@field:SerializedName("language")
	val language: MvLanguage? = null,

	@field:SerializedName("flavor_text")
	val flavorText: String? = null
)

data class MvMachine(

	@field:SerializedName("url")
	val url: String
)

data class MvVersionGroup(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvContestEffect(

	@field:SerializedName("url")
	val url: String
)

data class MvCategory(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvMeta(

	@field:SerializedName("healing")
	val healing: Int,

	@field:SerializedName("min_hits")
	val minHits: Any? = null,

	@field:SerializedName("max_hits")
	val maxHits: Any? = null,

	@field:SerializedName("ailment_chance")
	val ailmentChance: Int,

	@field:SerializedName("crit_rate")
	val critRate: Int,

	@field:SerializedName("flinch_chance")
	val flinchChance: Int,

	@field:SerializedName("min_turns")
	val minTurns: Any? = null,

	@field:SerializedName("ailment")
	val ailment: MvAilment,

	@field:SerializedName("category")
	val category: MvCategory,

	@field:SerializedName("max_turns")
	val maxTurns: Any? = null,

	@field:SerializedName("drain")
	val drain: Int,

	@field:SerializedName("stat_chance")
	val statChance: Int
)

data class MvLearnedByPokemonItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvNamesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("language")
	val language: MvLanguage
)

data class MvGeneration(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvSuperContestEffect(

	@field:SerializedName("url")
	val url: String
)

data class MvContestType(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvAilment(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class MvType(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
