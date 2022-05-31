package com.stdev.tmdb.data.repository.tvshow.datasource

import com.stdev.tmdb.data.model.tvshow.TvShow

interface TvShowLocalDatasource {

    suspend fun getTvShowsFromDB() : List<TvShow>
    suspend fun saveTvShowsToDB(tvShows : List<TvShow>)
    suspend fun clearAll()

}