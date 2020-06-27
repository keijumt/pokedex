package com.keijumt.pokedex.pokedex.infra.domain.impl.converter

import com.keijumt.pokedex.api.json.BaseStatJson
import com.keijumt.pokedex.api.json.PokemonDetailJson
import com.keijumt.pokedex.api.json.PokemonJson
import com.keijumt.pokedex.api.json.PokemonTypeJson
import com.keijumt.pokedex.pokedex.domain.model.BaseStat
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.model.PokemonId
import com.keijumt.pokedex.pokedex.domain.model.PokemonType

fun PokemonJson.toDomainModel(): Pokemon = Pokemon(
    id = PokemonId(url.split("/".toRegex()).let { it[it.lastIndex - 1] }),
    name = name
)

fun PokemonDetailJson.toDomainModel() = Pokemon(
    id = PokemonId(id.toString()),
    name = name,
    detail = Pokemon.Detail(
        weight = weight,
        height = height,
        types = types.map { it.type.toDomainModel() },
        baseStats = stats.map { it.toDomainModel() }
    )
)

fun PokemonTypeJson.toDomainModel(): PokemonType {
    return PokemonType.valueOf(name.toUpperCase())
}

fun BaseStatJson.toDomainModel(): BaseStat {
    return when (stat.name) {
        "hp" -> BaseStat.HP(stat.name, baseStat)
        "attack" -> BaseStat.ATTACK(stat.name, baseStat)
        "defense" -> BaseStat.DEFENSE(stat.name, baseStat)
        "special-attack" -> BaseStat.SPECIAL_ATTACK(stat.name, baseStat)
        "special-defense" -> BaseStat.SPECIAL_DEFENCE(stat.name, baseStat)
        "speed" -> BaseStat.SPEED(stat.name, baseStat)
        else -> throw IllegalArgumentException("Unsupported stat: ${stat.name}")
    }
}