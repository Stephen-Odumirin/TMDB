package com.stdev.tmdb.domain.repository

import com.stdev.tmdb.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?

    suspend fun updateMovies() : List<Movie>?

}