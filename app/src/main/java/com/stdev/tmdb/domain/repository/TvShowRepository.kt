package com.stdev.tmdb.domain.repository

import com.stdev.tmdb.data.model.tvshow.TvShow

interface TvShowRepository  {

    suspend fun getTvShows() : List<TvShow>?
    suspend fun updateTvShows() : List<TvShow>?

}