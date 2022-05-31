package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.data.db.ArtistDao
import com.stdev.tmdb.data.db.MovieDao
import com.stdev.tmdb.data.db.TvShowsDao
import com.stdev.tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.stdev.tmdb.data.repository.artist.datasourcelmpl.ArtistLocalDatasourceImpl
import com.stdev.tmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.stdev.tmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.stdev.tmdb.data.repository.movie.datasourcelmpl.MovieLocalDataSourceImpl
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.stdev.tmdb.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDatasource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowsDao: TvShowsDao) : TvShowLocalDatasource{
        return TvShowLocalDatasourceImpl(tvShowsDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDatasource{
        return ArtistLocalDatasourceImpl(artistDao)
    }

}