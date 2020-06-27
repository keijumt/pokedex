package com.keijumt.pokedex.api.json

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetailJson(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeResponseJson>,
    val stats: List<BaseStatJson>
)

@Serializable
data class PokemonTypeResponseJson(
    val slot: Int,
    val type: PokemonTypeJson
)

@Serializable
data class PokemonTypeJson(
    val name: String,
    val url: String
)

@Serializable
data class BaseStatJson(
    @SerialName(value = "base_stat")
    val baseStat: Int,
    val stat: NamedJson
)

