package com.keijumt.pokedex.pokedex.domain.model

class Pokemon(
    val id: PokemonId,
    val name: String
) {
    val imageUrl = "https://pokeres.bastionbot.org/images/pokemon/${id.value}.png"
}
