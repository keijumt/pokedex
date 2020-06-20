package com.keijumt.pokedex.pokedex.ui.pokemons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.keijumt.pokedex.pokedex.R
import com.keijumt.pokedex.pokedex.databinding.FragmentPokemonsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class PokemonsFragment : Fragment(R.layout.fragment_pokemons) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentPokemonsBinding.bind(view)

        val adapter = PokemonAdapter()
        binding.pokemonRecyclerView.layoutManager = GridLayoutManager(requireContext(), 2).apply {
            spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    if (position > adapter.itemCount - 1) {
                        return 2
                    }

                    return 1
                }
            }
            val mergeAdapter = adapter.withLoadStateFooter(LoadingStateAdapter())
            binding.pokemonRecyclerView.adapter = mergeAdapter

            val pokemonsViewModel: PokemonsViewModel by viewModels()
            lifecycleScope.launchWhenCreated {
                pokemonsViewModel.pokemons.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
    }
}