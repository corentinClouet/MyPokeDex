package com.coreclouet.data.networking.model

import com.coreclouet.data.database.DELIMITER
import com.coreclouet.data.database.model.TypeEntity
import com.google.gson.annotations.SerializedName

data class TypeRemote(

	@field:SerializedName("generation")
	val generation: TpGeneration,

	@field:SerializedName("game_indices")
	val gameIndices: List<TpGameIndicesItem>? = null,

	@field:SerializedName("move_damage_class")
	val moveDamageClass: TpMoveDamageClass?,

	@field:SerializedName("names")
	val names: List<TpNamesItem>? = null,

	@field:SerializedName("pokemon")
	val pokemon: List<TpPokemonItem>? = null,

	@field:SerializedName("damage_relations")
	val damageRelations: TpDamageRelations? = null,

	@field:SerializedName("moves")
	val moves: List<TpMovesItem>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
) {
	fun mapToRoomEntity(): TypeEntity {
		return TypeEntity(
			typeId = this.id,
			typeName = this.name,
			generationName = this.generation.name,
			moveDamageClassName = this.moveDamageClass?.name,
			doubleDamageFrom = this.damageRelations?.doubleDamageFrom?.joinToString(separator = DELIMITER) { it -> it.name },
			doubleDamageTo = this.damageRelations?.doubleDamageTo?.joinToString(DELIMITER) { it -> it.name },
			halfDamageFrom = this.damageRelations?.halfDamageFrom?.joinToString(DELIMITER) { it -> it.name },
			halfDamageTo = this.damageRelations?.halfDamageTo?.joinToString(DELIMITER) { it -> it.name },
			noDamageFrom = this.damageRelations?.noDamageFrom?.joinToString(DELIMITER) { it -> it.name },
			noDamageTo = this.damageRelations?.noDamageTo?.joinToString(DELIMITER) { it -> it.name }
		)
	}
}

data class TpDoubleDamageToItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpLanguage(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpHalfDamageToItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpGameIndicesItem(

	@field:SerializedName("generation")
	val generation: TpGeneration,

	@field:SerializedName("game_index")
	val gameIndex: Int
)

data class TpDoubleDamageFromItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpHalfDamageFromItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpMovesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpPokemonItem(

	@field:SerializedName("pokemon")
	val pokemon: TpPokemon,

	@field:SerializedName("slot")
	val slot: Int
)

data class TpNamesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("language")
	val language: TpLanguage
)

data class TpPokemon(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpMoveDamageClass(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpGeneration(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpDamageRelations(

	@field:SerializedName("no_damage_from")
	val noDamageFrom: List<TpNoDamageFromItem>? = null,

	@field:SerializedName("half_damage_from")
	val halfDamageFrom: List<TpHalfDamageFromItem>? = null,

	@field:SerializedName("no_damage_to")
	val noDamageTo: List<TpNoDamageToItem>? = null,

	@field:SerializedName("half_damage_to")
	val halfDamageTo: List<TpHalfDamageToItem>? = null,

	@field:SerializedName("double_damage_to")
	val doubleDamageTo: List<TpDoubleDamageToItem>? = null,

	@field:SerializedName("double_damage_from")
	val doubleDamageFrom: List<TpDoubleDamageFromItem>? = null
)

data class TpNoDamageFromItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class TpNoDamageToItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
