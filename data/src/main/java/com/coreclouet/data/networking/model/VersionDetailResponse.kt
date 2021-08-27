package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class VersionDetailResponse(

	@field:SerializedName("names")
	val names: List<NamesItem?>? = null,

	@field:SerializedName("version_group")
	val versionGroup: VersionGroup? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class VersionGroup(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
