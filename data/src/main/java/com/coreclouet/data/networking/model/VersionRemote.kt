package com.coreclouet.data.networking.model

import com.coreclouet.data.database.model.VersionEntity
import com.google.gson.annotations.SerializedName

data class VersionRemote(

	@field:SerializedName("names")
	val names: List<VersionNamesItem>? = null,

	@field:SerializedName("version_group")
	val versionGroup: VersionGroup,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int
) {
	fun mapToRoomEntity(): VersionEntity {
		return VersionEntity(
			versionId = this.id,
			versionName = this.name,
			versionGroupName = this.versionGroup.name
		)
	}
}

data class VersionGroup(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("url")
	val url: String
)

data class VersionNamesItem(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("language")
	val language: AbLanguage
)
