package com.stdev.tmdb.ui.di.tvshow

import com.stdev.tmdb.domain.usecase.*
import com.stdev.tmdb.ui.artist.ArtistsViewModelFactory
import com.stdev.tmdb.ui.movie.MovieViewModelFactory
import com.stdev.tmdb.ui.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ) : TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }

}