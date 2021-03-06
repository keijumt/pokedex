package com.keijumt.pokedex.pokedex.ui.bindingmodel

import com.keijumt.pokedex.pokedex.domain.model.BaseStats
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.model.PokemonType

internal fun Pokemon.toBindingModel(): PokemonBindingModel {
    return PokemonBindingModel(
        id = id.value,
        number = number,
        name = name,
        imageUrl = imageUrl
    )
}

internal fun Pokemon.toDetailBindingModel(): PokemonDetailBindingModel? {
    val detail = detail ?: return null
    return PokemonDetailBindingModel(
        id = id.value,
        number = number,
        name = name,
        imageUrl = imageUrl,
        weight = detail.weight,
        height = detail.height,
        types = detail.types.map { it.toBindingModel() },
        baseStats = detail.baseStats.toBindingModel()
    )
}

internal fun PokemonType.toBindingModel(): PokemonTypeBindingModel {
    return when (this) {
        PokemonType.NORMAL -> PokemonTypeBindingModel.NORMAL
        PokemonType.FIGHTING -> PokemonTypeBindingModel.FIGHTING
        PokemonType.FLYING -> PokemonTypeBindingModel.FLYING
        PokemonType.POISON -> PokemonTypeBindingModel.POISON
        PokemonType.GROUND -> PokemonTypeBindingModel.GROUND
        PokemonType.ROCK -> PokemonTypeBindingModel.ROCK
        PokemonType.BUG -> PokemonTypeBindingModel.BUG
        PokemonType.GHOST -> PokemonTypeBindingModel.GHOST
        PokemonType.STEEL -> PokemonTypeBindingModel.STEEL
        PokemonType.FIRE -> PokemonTypeBindingModel.FIRE
        PokemonType.WATER -> PokemonTypeBindingModel.WATER
        PokemonType.GRASS -> PokemonTypeBindingModel.GRASS
        PokemonType.ELECTRIC -> PokemonTypeBindingModel.ELECTRIC
        PokemonType.PSYCHIC -> PokemonTypeBindingModel.PSYCHIC
        PokemonType.ICE -> PokemonTypeBindingModel.ICE
        PokemonType.DRAGON -> PokemonTypeBindingModel.DRAGON
        PokemonType.DARK -> PokemonTypeBindingModel.DARK
        PokemonType.FAIRY -> PokemonTypeBindingModel.FAIRY
        PokemonType.UNKNOWN -> PokemonTypeBindingModel.UNKNOWN
        PokemonType.SHADOW -> PokemonTypeBindingModel.SHADOW
    }
}

internal fun BaseStats.toBindingModel() = BaseStatsBindingModel(
    hp, attack, defence, specialAttack, specialDefence, speed
)
