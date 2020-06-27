package com.keijumt.pokedex.pokedex.ui.bindingmodel

data class PokemonDetailBindingModel(
    val id: String,
    val number: Int,
    val name: String,
    val imageUrl: String,
    val weight: Int,
    val height: Int,
    val types: List<PokemonTypeBindingModel>,
    val baseStats: BaseStatsBindingModel
)

enum class PokemonTypeBindingModel {
    NORMAL,
    FIGHTING,
    FLYING,
    POISON,
    GROUND,
    ROCK,
    BUG,
    GHOST,
    STEEL,
    FIRE,
    WATER,
    GRASS,
    ELECTRIC,
    PSYCHIC,
    ICE,
    DRAGON,
    DARK,
    FAIRY,
    UNKNOWN,
    SHADOW;
}

data class BaseStatsBindingModel(
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val specialAttack: Int,
    val specialDefence: Int,
    val speed: Int
)
