package com.stdev.tmdb.data.repository.movie.datasource

import com.stdev.tmdb.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache() : List<Movie>
    suspend fun saveMoviesToCache(movies : List<Movie>)
}