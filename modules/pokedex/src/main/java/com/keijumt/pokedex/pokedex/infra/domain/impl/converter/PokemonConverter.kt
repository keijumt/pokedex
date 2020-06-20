package com.keijumt.pokedex.pokedex.infra.domain.impl.converter

import com.keijumt.pokedex.api.json.PokemonJson
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.model.PokemonId

fun PokemonJson.convert(): Pokemon = Pokemon(
    id = PokemonId(url.split("/".toRegex()).let { it[it.lastIndex - 1] }),
    name = name
)
