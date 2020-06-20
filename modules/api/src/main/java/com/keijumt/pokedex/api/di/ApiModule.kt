package com.keijumt.pokedex.api.di

import com.keijumt.pokedex.api.PokedexApi
import com.keijumt.pokedex.api.PokedexApiFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providePokedexApi(): PokedexApi = PokedexApiFactory.create()
}