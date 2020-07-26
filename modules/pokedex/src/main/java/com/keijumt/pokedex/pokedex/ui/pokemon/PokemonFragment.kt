package com.keijumt.pokedex.pokedex.ui.pokemon

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.keijumt.pokedex.common.bindingadapter.LoadState
import com.keijumt.pokedex.pokedex.R
import com.keijumt.pokedex.pokedex.databinding.FragmentPokemonBinding
import com.keijumt.pokedex.pokedex.domain.model.PokemonId
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.migration.DisableInstallInCheck
import javax.inject.Inject
import com.keijumt.pokedex.resource.R.color as resourceColor


@AndroidEntryPoint
class PokemonFragment : Fragment(R.layout.fragment_pokemon) {

    @Inject
    lateinit var vmFactory: PokemonViewModel.Factory

    private val navController: NavController by lazy {
        findNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args by navArgs<PokemonFragmentArgs>()
        val pokemonViewModel = vmFactory.create(PokemonId(args.pokemonId))

        val binding = FragmentPokemonBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = pokemonViewModel
        }

        sharedElementEnterTransition = MaterialContainerTransform()

        binding.toolbar.setNavigationOnClickListener {
            navController.popBackStack()
        }

        pokemonViewModel.pokemon.observe(viewLifecycleOwner) {
            if (it is LoadState.Loaded) {
                binding.pokemon = it.value
            }
        }

        resourceColor.color_on_normal
    }
}

@AssistedModule
@DisableInstallInCheck
@InstallIn(ActivityRetainedComponent::class)
@Module(includes = [AssistedInject_PokemonFragmentModule::class])
interface PokemonFragmentModule
