package com.keijumt.pokedex.pokedex.infra.domain.impl.converter

import com.keijumt.pokedex.api.json.BaseStatJson
import com.keijumt.pokedex.api.json.PokemonDetailJson
import com.keijumt.pokedex.api.json.PokemonJson
import com.keijumt.pokedex.api.json.PokemonTypeJson
import com.keijumt.pokedex.pokedex.domain.model.BaseStats
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.model.PokemonId
import com.keijumt.pokedex.pokedex.domain.model.PokemonType

fun PokemonJson.toDomainModel(): Pokemon {
    val number = url.split("/".toRegex()).let { it[it.lastIndex - 1] }
    return Pokemon(
        id = PokemonId(number),
        number = number.toInt(),
        name = name
    )
}

fun PokemonDetailJson.toDomainModel() = Pokemon(
    id = PokemonId(id.toString()),
    number = id,
    name = name,
    detail = Pokemon.Detail(
        weight = weight,
        height = height,
        types = types.map { it.type.toDomainModel() },
        baseStats = stats.toDomainModel()
    )
)

fun PokemonTypeJson.toDomainModel(): PokemonType {
    return PokemonType.valueOf(name.toUpperCase())
}

fun List<BaseStatJson>.toDomainModel() = BaseStats(
    hp = find { it.stat.name == "hp" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat hp"),
    attack = find { it.stat.name == "attack" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat attack"),
    defence = find { it.stat.name == "defense" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat defense"),
    specialAttack = find { it.stat.name == "special-attack" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat special-attack"),
    specialDefence = find { it.stat.name == "special-defense" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat special-defense"),
    speed = find { it.stat.name == "speed" }?.baseStat
        ?: throw IllegalArgumentException("Unsupported stat speed")
)
