package com.stdev.tmdb.data.repository.tvshow.datasourceImpl

import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDatasourceImpl : TvShowCacheDataSource{
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShows)
    }
}