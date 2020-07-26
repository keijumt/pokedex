package com.keijumt.pokedex.pokedex.ui.pokemons

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.keijumt.pokedex.pokedex.R
import com.keijumt.pokedex.pokedex.databinding.FragmentPokemonsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class PokemonsFragment : Fragment(R.layout.fragment_pokemons) {

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentPokemonsBinding.bind(view)
        val pokemonsViewModel: PokemonsViewModel by viewModels()

        val adapter = PokemonAdapter(pokemonsViewModel).apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
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

            lifecycleScope.launchWhenCreated {
                pokemonsViewModel.pokemons.collectLatest {
                    adapter.submitData(it)
                }
            }

            pokemonsViewModel.navigateToPokemon.observe(viewLifecycleOwner) { (position, pokemonId) ->
                val pokemonCard = (binding.pokemonRecyclerView.findViewHolderForAdapterPosition(position) as? PokemonAdapter.PokemonViewHolder)?.binding?.pokemonCard ?: return@observe

                pokemonCard.transitionName = getString(R.string.pokemon_card_transition_name, pokemonId)
                val extras = FragmentNavigatorExtras(pokemonCard to pokemonCard.transitionName)
                val directions = PokemonsFragmentDirections.actionPokemonsToPokemon(pokemonId)
                navController.navigate(directions, extras)
            }
        }
    }
}