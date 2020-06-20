package com.keijumt.pokedex.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object PokedexApiFactory {
    @OptIn(UnstableDefault::class)
    fun create(): PokedexApi = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .client(
            OkHttpClient.Builder()
                .build()
        )
        .addConverterFactory(Json(JsonConfiguration(ignoreUnknownKeys = true)).asConverterFactory("application/json".toMediaType()))
        .build()
        .create(PokedexApi::class.java)
}