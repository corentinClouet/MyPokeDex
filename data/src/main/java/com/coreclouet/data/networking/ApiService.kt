package com.coreclouet.data.networking

import com.coreclouet.data.networking.model.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("version")
    suspend fun getVersions(): Response<VersionListRemote>

    @GET("version/{name}")
    suspend fun getVersionByName(@Path("name") name: String): Response<VersionRemote?>

    @GET("version-group")
    suspend fun getVersionsGroups(): Response<VersionGroupListRemote?>

    @GET("version-group/{name}")
    suspend fun getVersionGroupByName(@Path("name") name: String): Response<VersionGroupRemote?>

    @GET("generation")
    suspend fun getGenerations(): Response<GenerationListRemote>

    @GET("generation/{name}")
    suspend fun getGenerationByName(@Path("name") name: String): Response<GenerationRemote?>

    @GET("ability/{name}")
    suspend fun getAbilityByName(@Path("name") name: String): Response<AbilityRemote?>

    @GET("ability/{id}")
    suspend fun getAbilityById(@Path("id") id: Int): Response<AbilityRemote?>

    @GET("pokemon")
    suspend fun getPokemons(): Response<PokemonListRemote?>

    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): Response<PokemonRemote?>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Response<PokemonRemote?>

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpecies(@Path("name") name: String): Response<PokemonSpeciesRemote?>

    @GET("type/{name}")
    suspend fun getTypeByName(@Path("name") name: String): Response<TypeRemote?>

    @GET("type/{id}")
    suspend fun getTypeById(@Path("id") id: Int): Response<TypeRemote?>
}