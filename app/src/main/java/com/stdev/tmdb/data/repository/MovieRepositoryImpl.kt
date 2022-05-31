package com.stdev.tmdb.data.repository

import android.util.Log
import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.data.repository.movie.datasource.MovieCacheDataSource
import com.stdev.tmdb.data.repository.movie.datasource.MovieLocalDatasource
import com.stdev.tmdb.data.repository.movie.datasource.MovieRemoteDatasource
import com.stdev.tmdb.domain.repository.MovieRepository
import java.lang.Exception

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MovieRepository {

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newList = getMoviesFromAPI()
        movieLocalDatasource.clearAll()
        movieLocalDatasource.saveMoviesToDB(newList)
        movieCacheDataSource.saveMoviesToCache(newList)
        return newList
    }

    suspend fun getMoviesFromAPI() : List<Movie>{
        var movieList : List<Movie> = listOf()
        val response = movieRemoteDatasource.getMovies()
        val body = response.body()
        if(body != null){
            movieList = body.movies
        }else{
            Log.i("MyTag","list is null")
        }
//        try {
//            val response = movieRemoteDatasource.getMovies()
//            val body = response.body()
//            if(body != null){
//                movieList = body.movies
//            }
//        }catch (e : Exception){
//            Log.i("MyTag",e.localizedMessage)
//        }

        return movieList
    }

    suspend fun getMoviesFromDB() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieLocalDatasource.getMoviesFromDB()
        }catch (e : Exception){
            Log.i("MYTAG",e.localizedMessage)
        }
        if (movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToDB(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache() : List<Movie>{
        lateinit var movieList : List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (e : Exception){
            Log.i("MYTAG",e.localizedMessage)
        }
        if(movieList.isNotEmpty()){
            return movieList
        }else{
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}