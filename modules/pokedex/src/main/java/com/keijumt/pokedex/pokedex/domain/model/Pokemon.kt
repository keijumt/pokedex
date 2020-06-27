package com.keijumt.pokedex.pokedex.domain.model

class Pokemon(
    val id: PokemonId,
    val name: String,
    val detail: Detail? = null
) {
    class Detail(
        val height: Int,
        val weight: Int,
        val types: List<PokemonType>,
        val baseStats: List<BaseStat>
    )

    val imageUrl = "https://pokeres.bastionbot.org/images/pokemon/${id.value}.png"

}
