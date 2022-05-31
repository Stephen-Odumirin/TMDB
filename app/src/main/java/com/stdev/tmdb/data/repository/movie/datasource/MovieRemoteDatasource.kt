package com.stdev.tmdb.data.repository.movie.datasource

import com.stdev.tmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {

    suspend fun getMovies() : Response<MovieList>

}