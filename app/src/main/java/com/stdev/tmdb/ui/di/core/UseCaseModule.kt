package com.stdev.tmdb.ui.di.core

import android.text.style.UpdateAppearance
import com.stdev.tmdb.domain.repository.ArtistRepository
import com.stdev.tmdb.domain.repository.MovieRepository
import com.stdev.tmdb.domain.repository.TvShowRepository
import com.stdev.tmdb.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideArtistUseCase(artistRepository: ArtistRepository) : GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistRepository)
    }


    @Provides
    fun providesGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun providesUpdateTvShowUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }

}