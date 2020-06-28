package com.keijumt.pokedex.pokedex.ui.bindingmodel

data class BaseStatsBindingModel(
    val hp: Int,
    val attack: Int,
    val defence: Int,
    val specialAttack: Int,
    val specialDefence: Int,
    val speed: Int
) {
    val total: Int = hp + attack + defence + specialAttack + specialDefence + speed
}
