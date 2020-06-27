package com.keijumt.pokedex.api

import com.keijumt.pokedex.api.json.PokemonDetailJson
import com.keijumt.pokedex.api.json.PokemonResponseJson
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexApi {

    @GET("pokemon")
    suspend fun pokemons(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonResponseJson

    @GET("pokemon/{id}")
    suspend fun pokemon(
        @Path("id") id: String
    ): PokemonDetailJson
}