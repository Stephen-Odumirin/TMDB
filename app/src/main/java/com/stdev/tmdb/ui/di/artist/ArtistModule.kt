package com.stdev.tmdb.ui.di.artist

import com.stdev.tmdb.domain.usecase.GetArtistsUseCase
import com.stdev.tmdb.domain.usecase.UpdateArtistsUseCase
import com.stdev.tmdb.ui.artist.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ) : ArtistsViewModelFactory{
        return ArtistsViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }

}