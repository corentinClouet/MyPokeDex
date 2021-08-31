package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class VersionGroupListRemote(

	@field:SerializedName("next")
	val next: Any? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<VgItem>? = null
)

data class VgItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
