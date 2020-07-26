package com.keijumt.pokedex.pokedex.ui.pokemons

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.keijumt.pokedex.common.util.SingleEventLiveData
import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository
import com.keijumt.pokedex.pokedex.ui.bindingmodel.toBindingModel
import kotlinx.coroutines.flow.map

class PokemonsViewModel @ViewModelInject constructor(
    pokemonRepository: PokemonRepository
) : ViewModel(), PokemonAdapterListener {
    val pokemons = Pager(
        PagingConfig(pageSize = 30, initialLoadSize = 50)
    ) {
        PokemonPagingSource(pokemonRepository)
    }
        .flow
        .map { it.map { pokemon -> pokemon.toBindingModel() } }
        .cachedIn(viewModelScope)

    private val _navigateToPokemon = SingleEventLiveData<Pair<Int, String>>()
    val navigateToPokemon: LiveData<Pair<Int, String>> = _navigateToPokemon

    override fun onPokemonClick(position: Int, pokemonId: String) {
        _navigateToPokemon.value = position to pokemonId
    }
}
