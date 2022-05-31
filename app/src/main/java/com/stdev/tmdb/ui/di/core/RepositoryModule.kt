package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.data.repository.ArtistRepositoryImpl
import com.stdev.tmdb.data.repository.MovieRepositoryImpl
import com.stdev.tmdb.data.repository.TvshowRepositoryImpl
import com.stdev.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.stdev.tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.stdev.tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.stdev.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.stdev.tmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.stdev.tmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.stdev.tmdb.domain.repository.ArtistRepository
import com.stdev.tmdb.domain.repository.MovieRepository
import com.stdev.tmdb.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDatasource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ) : TvShowRepository{
        return TvshowRepositoryImpl(tvShowCacheDataSource,tvShowLocalDatasource, tvShowRemoteDatasource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository{
        return ArtistRepositoryImpl(artistCacheDataSource,artistLocalDatasource, artistRemoteDatasource)
    }


}