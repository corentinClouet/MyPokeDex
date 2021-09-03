package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class EncounterRemote(

	@field:SerializedName("EncounterRemote")
	val encounterRemote: List<EncounterRemoteItem>? = null
)

data class EnVersionDetailsItem(

	@field:SerializedName("max_chance")
	val maxChance: Int? = null,

	@field:SerializedName("encounter_details")
	val encounterDetails: List<EncounterDetailsItem>? = null,

	@field:SerializedName("version")
	val version: EnVersion? = null
)

data class EncounterRemoteItem(

	@field:SerializedName("version_details")
	val versionDetails: List<EnVersionDetailsItem>? = null,

	@field:SerializedName("location_area")
	val locationArea: EnLocationArea? = null
)

data class EnVersion(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class EnLocationArea(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class EncounterDetailsItem(

	@field:SerializedName("condition_values")
	val conditionValues: List<Any?>? = null,

	@field:SerializedName("chance")
	val chance: Int,

	@field:SerializedName("method")
	val method: EnMethod? = null,

	@field:SerializedName("max_level")
	val maxLevel: Int,

	@field:SerializedName("min_level")
	val minLevel: Int
)

data class EnMethod(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
