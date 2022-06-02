package com.stdev.tmdb.data.db.repository.movie

import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    private val movies = mutableListOf<Movie>()

    init {
        movies.add(Movie(1,"overview1","path1","title1"))
        movies.add(Movie(2,"overview2","path2","title2"))
        movies.add(Movie(3,"overview3","path3","title3"))
        movies.add(Movie(4,"overview4","path4","title4"))
        movies.add(Movie(5,"overview5","path5","title5"))
    }

    override suspend fun getMovies(): List<Movie>? {
        return movies
    }

    override suspend fun updateMovies(): List<Movie>? {
        movies.clear()
        movies.add(Movie(11,"overview11","path11","title11"))
        movies.add(Movie(12,"overview12","path12","title12"))
        movies.add(Movie(13,"overview13","path13","title13"))
        movies.add(Movie(14,"overview14","path14","title14"))
        movies.add(Movie(15,"overview15","path15","title15"))
        return movies
    }
}