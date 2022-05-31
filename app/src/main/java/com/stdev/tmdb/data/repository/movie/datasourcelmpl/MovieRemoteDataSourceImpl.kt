package com.stdev.tmdb.data.repository.movie.datasourcelmpl

import com.stdev.tmdb.data.api.TMBDService
import com.stdev.tmdb.data.model.movie.MovieList
import com.stdev.tmdb.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDataSourceImpl(private val tmbdService: TMBDService, private val apiKey : String
) : MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmbdService.getPopularMovies(apiKey)
    }
}