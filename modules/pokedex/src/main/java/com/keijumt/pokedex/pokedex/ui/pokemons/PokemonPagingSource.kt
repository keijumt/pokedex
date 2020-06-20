package com.keijumt.pokedex.pokedex.ui.pokemons

import androidx.paging.PagingSource
import com.keijumt.pokedex.pokedex.domain.model.Pokemon
import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository

class PokemonPagingSource(
    private val pokemonRepository: PokemonRepository
) : PagingSource<Int, Pokemon>() {
    private var loadedSize: Int = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val page = params.key ?: 0

        return try {
            val pokemons = pokemonRepository.findAll(loadedSize, params.loadSize)

            loadedSize += params.loadSize

            LoadResult.Page(
                data = pokemons,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (pokemons.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
