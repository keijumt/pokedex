package com.keijumt.pokedex.pokedex.ui.pokemons

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.keijumt.pokedex.pokedex.databinding.ItemLoadingBinding
import com.keijumt.pokedex.pokedex.databinding.ItemPokemonBinding
import com.keijumt.pokedex.pokedex.ui.bindingmodel.PokemonBindingModel

class PokemonAdapter(private val listener: PokemonAdapterListener) :
    PagingDataAdapter<PokemonBindingModel, PokemonAdapter.PokemonViewHolder>(PokemonDiffItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            ItemPokemonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, listener)
        }
    }

    class PokemonViewHolder(val binding: ItemPokemonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemonBindingModel: PokemonBindingModel, listener: PokemonAdapterListener) {
            binding.pokemon = pokemonBindingModel
            binding.listener = listener
            binding.position = layoutPosition
            binding.executePendingBindings()
        }
    }

    override fun onViewRecycled(holder: PokemonViewHolder) {
        Glide.with(holder.binding.root).clear(holder.binding.pokemonImage)
    }
}

class LoadingStateAdapter : LoadStateAdapter<LoadStateViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            ItemLoadingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }
}

class LoadStateViewHolder(
    val binding: ItemLoadingBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(loadState: LoadState) {
        binding.progress.isVisible = loadState is LoadState.Loading
    }
}

private object PokemonDiffItemCallback : DiffUtil.ItemCallback<PokemonBindingModel>() {
    override fun areItemsTheSame(
        oldItem: PokemonBindingModel,
        newItem: PokemonBindingModel
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: PokemonBindingModel,
        newItem: PokemonBindingModel
    ): Boolean {
        return oldItem == newItem
    }
}