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
) {
    val capitalizedName: String = name.capitalize()

    val firstType: PokemonTypeBindingModel = types[0]
    val secondType: PokemonTypeBindingModel? = types.getOrNull(1)
}

