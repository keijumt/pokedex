package com.keijumt.pokedex.pokedex.ui.pokemon

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
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

    val pokemon: LiveData<PokemonDetailBindingModel> =
        liveData(context = viewModelScope.coroutineContext) {
            pokemonRepository.findById(pokemonId).toDetailBindingModel()?.let {
                emit(it)
            }
        }
}

