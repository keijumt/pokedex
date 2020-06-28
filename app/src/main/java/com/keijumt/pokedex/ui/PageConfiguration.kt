package com.keijumt.pokedex.ui

import androidx.annotation.IdRes
import com.keijumt.pokedex.R

enum class PageConfiguration(
    val id: Int,
    val hideToolbar: Boolean = false
) {
    Pokemons(
        R.id.pokemons
    ),
    Pokemon(
        R.id.pokemon,
        hideToolbar = true
    ),
    Other(0);

    companion object {
        fun getConfiguration(@IdRes id: Int): PageConfiguration {
            return enumValues<PageConfiguration>().firstOrNull { it.id == id } ?: Other
        }
    }
}
