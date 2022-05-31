package com.stdev.tmdb.data.repository.movie.datasource

import com.stdev.tmdb.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB() : List<Movie>
    suspend fun saveMoviesToDB(movies : List<Movie>)
    suspend fun clearAll()

}