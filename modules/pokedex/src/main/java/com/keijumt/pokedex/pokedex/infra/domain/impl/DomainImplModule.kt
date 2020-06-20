package com.keijumt.pokedex.pokedex.infra.domain.impl

import com.keijumt.pokedex.api.PokedexApi
import com.keijumt.pokedex.pokedex.domain.repository.PokemonRepository
import com.keijumt.pokedex.pokedex.infra.domain.impl.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object DomainImplModule {

    @Provides
    @Singleton
    fun providePokemonRepository(
        pokedexApi: PokedexApi
    ): PokemonRepository {
        return PokemonRepositoryImpl(pokedexApi)
    }
}