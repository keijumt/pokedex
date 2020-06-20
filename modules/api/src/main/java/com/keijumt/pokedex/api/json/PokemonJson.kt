package com.keijumt.pokedex.api.json

import kotlinx.serialization.Serializable

@Serializable
data class PokemonJson(
    val name: String,
    val url: String
)
