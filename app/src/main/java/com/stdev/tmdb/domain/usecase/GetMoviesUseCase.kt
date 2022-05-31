package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute() : List<Movie>? = movieRepository.getMovies()
}