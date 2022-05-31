package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.data.api.TMBDService
import com.stdev.tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.stdev.tmdb.data.repository.artist.datasourcelmpl.ArtistRemoteDatasourceImpl
import com.stdev.tmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.stdev.tmdb.data.repository.movie.datasourcelmpl.MovieRemoteDataSourceImpl
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.stdev.tmdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey : String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmbdService: TMBDService) : MovieRemoteDatasource{
        return MovieRemoteDataSourceImpl(tmbdService, apiKey)
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDatasource(tmbdService: TMBDService) : TvShowRemoteDatasource{
        return TvShowRemoteDatasourceImpl(tmbdService, apiKey)
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(tmbdService: TMBDService) : ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(tmbdService, apiKey)
    }

}