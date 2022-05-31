package com.stdev.tmdb.ui.di.movie

import com.stdev.tmdb.domain.usecase.GetArtistsUseCase
import com.stdev.tmdb.domain.usecase.GetMoviesUseCase
import com.stdev.tmdb.domain.usecase.UpdateArtistsUseCase
import com.stdev.tmdb.domain.usecase.UpdateMoviesUseCase
import com.stdev.tmdb.ui.artist.ArtistsViewModelFactory
import com.stdev.tmdb.ui.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMovieUseCase: GetMoviesUseCase,
        updateMovieUseCase: UpdateMoviesUseCase
    ) : MovieViewModelFactory{
        return MovieViewModelFactory(getMovieUseCase, updateMovieUseCase)
    }

}