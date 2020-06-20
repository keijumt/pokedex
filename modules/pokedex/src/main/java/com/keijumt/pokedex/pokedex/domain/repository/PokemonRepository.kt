package com.keijumt.pokedex.pokedex.domain.repository

import com.keijumt.pokedex.pokedex.domain.model.Pokemon

interface PokemonRepository {
    suspend fun findAll(page: Int, per: Int): List<Pokemon>
}