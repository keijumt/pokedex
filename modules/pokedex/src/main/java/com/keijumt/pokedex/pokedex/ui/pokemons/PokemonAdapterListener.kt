package com.keijumt.pokedex.pokedex.ui.pokemons

interface PokemonAdapterListener {
    fun onPokemonClick(position:Int, pokemonId: String)
}