package com.keijumt.pokedex.pokedex.ui.pokemon

import androidx.lifecycle.*
import com.keijumt.pokedex.common.bindingadapter.LoadState
import com.keijumt.pokedex.pokedex.domain.model.PokemonId
import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository
import com.keijumt.pokedex.pokedex.ui.bindingmodel.PokemonDetailBindingModel
import com.keijumt.pokedex.pokedex.ui.bindingmodel.toDetailBindingModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class PokemonViewModel @AssistedInject constructor(
    pokemonRepository: PokemonRepository,
    @Assisted pokemonId: PokemonId
) : ViewModel() {

    @AssistedInject.Factory
    interface Factory {
        fun create(pokemonId: PokemonId): PokemonViewModel
    }

    val pokemon: LiveData<LoadState<PokemonDetailBindingModel>> =
        liveData(context = viewModelScope.coroutineContext) {
            emit(LoadState.Loading)
            try {
                pokemonRepository.findById(pokemonId).toDetailBindingModel()?.let {
                    emit(LoadState.Loaded(it))
                }
            } catch (e: Exception) {
                emit(LoadState.Error<PokemonDetailBindingModel>(e))
            }
        }

    val loading: LiveData<Boolean> = pokemon.map { it is LoadState.Loading }
}

