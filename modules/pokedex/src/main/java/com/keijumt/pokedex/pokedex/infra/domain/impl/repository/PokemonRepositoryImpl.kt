package com.keijumt.pokedex.pokedex.infra.domain.impl.repository

import com.keijumt.pokedex.api.PokedexApi
import com.keijumt.pokedex.pokedex.infra.domain.impl.converter.convert
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

internal class PokemonRepositoryImpl @Inject constructor(
    private val pokedexApi: PokedexApi
) : PokemonRepository {
    override suspend fun findAll(page: Int, per: Int): List<Pokemon> {
        return pokedexApi.pokemons(page, per).results.map { it.convert() }
    }
}