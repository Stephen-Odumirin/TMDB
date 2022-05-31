package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.stdev.tmdb.data.repository.artist.datasourcelmpl.ArtistCacheDatasourceImpl
import com.stdev.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.stdev.tmdb.data.repository.movie.datasourcelmpl.MovieCacheDataSourceImpl
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.stdev.tmdb.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun movieCacheDataSource() : MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun artistCacheDataSource() : ArtistCacheDataSource{
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun tvShowCacheDataSource() : TvShowCacheDataSource{
        return TvShowCacheDatasourceImpl()
    }

}