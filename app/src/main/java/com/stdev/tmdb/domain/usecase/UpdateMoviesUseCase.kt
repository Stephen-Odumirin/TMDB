package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.domain.repository.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun excecute() : List<Movie>? = movieRepository.updateMovies()

}