package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class GenerationListRemote(

	@field:SerializedName("next")
	val next: Any,

	@field:SerializedName("previous")
	val previous: Any,

	@field:SerializedName("count")
	val count: Int,

	@field:SerializedName("results")
	val results: List<GenerationItem>? = null
)

data class GenerationItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)
