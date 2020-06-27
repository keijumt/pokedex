package com.keijumt.pokedex.pokedex.ui.bindingmodel

data class PokemonDetailBindingModel(
    val id: String,
    val name: String,
    val imageUrl: String,
    val weight: Int,
    val height: Int,
    val types: List<PokemonTypeBindingModel>,
    val baseStats: List<BaseStatBindingModel>
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

sealed class BaseStatBindingModel {
    data class HP(val name: String, val value: Int) : BaseStatBindingModel()
    data class ATTACK(val name: String, val value: Int) : BaseStatBindingModel()
    data class DEFENSE(val name: String, val value: Int) : BaseStatBindingModel()
    data class SPECIAL_ATTACK(val name: String, val value: Int) : BaseStatBindingModel()
    data class SPECIAL_DEFENCE(val name: String, val value: Int) : BaseStatBindingModel()
    data class SPEED(val name: String, val value: Int) : BaseStatBindingModel()
}

