package com.stdev.tmdb.data.repository.movie.datasourcelmpl

import com.stdev.tmdb.data.db.MovieDao
import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}