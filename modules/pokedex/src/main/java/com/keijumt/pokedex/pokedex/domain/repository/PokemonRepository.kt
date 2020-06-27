package com.keijumt.pokedex.pokedex.domain.repository

import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.model.PokemonId

interface PokemonRepository {
    suspend fun findAll(page: Int, per: Int): List<Pokemon>
    suspend fun findById(id: PokemonId): Pokemon
}