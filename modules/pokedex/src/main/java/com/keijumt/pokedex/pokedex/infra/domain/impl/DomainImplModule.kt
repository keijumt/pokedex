package com.keijumt.pokedex.pokedex.infra.domain.impl

import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository
import com.keijumt.pokedex.pokedex.infra.domain.impl.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
internal abstract class DomainImplModule {

    @Binds
    @Singleton
    abstract fun bindsPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}