package com.keijumt.pokedex.api.json

import kotlinx.serialization.Serializable

@Serializable
data class NamedJson(
    val name: String,
    val url: String
)