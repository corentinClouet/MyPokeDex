package com.coreclouet.data.networking.model

import com.google.gson.annotations.SerializedName

data class GenerationListResponse(

	@field:SerializedName("next")
	val next: Any? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<GenerationItem?>? = null
)

data class GenerationItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
