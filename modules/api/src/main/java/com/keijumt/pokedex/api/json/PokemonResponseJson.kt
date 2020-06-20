package com.keijumt.pokedex.api.json

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponseJson(
    val results: List<PokemonJson>
)
