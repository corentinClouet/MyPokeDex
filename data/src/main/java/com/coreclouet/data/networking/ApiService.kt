package com.coreclouet.data.networking

import com.coreclouet.data.networking.model.VersionDetailResponse
import com.coreclouet.data.networking.model.VersionListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("version")
    suspend fun getVersions(): Response<VersionListResponse>

    @GET("version/{id}")
    suspend fun getVersionById(@Path("id") id: Long): Response<VersionDetailResponse>

    @GET("version/{name}")
    suspend fun getVersionByName(@Path("name") name: String): Response<VersionDetailResponse?>
}