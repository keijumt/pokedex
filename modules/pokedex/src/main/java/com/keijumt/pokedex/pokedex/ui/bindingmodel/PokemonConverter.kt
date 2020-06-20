package com.keijumt.pokedex.pokedex.ui.bindingmodel

import com.keijumt.pokedex.pokedex.domain.model.Pokemon

internal fun Pokemon.toBindingModel(): PokemonBindingModel {
    return PokemonBindingModel(
        id = id.value,
        name = name,
        imageUrl = imageUrl
    )
}