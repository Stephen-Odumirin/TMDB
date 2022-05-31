package com.stdev.tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.stdev.tmdb.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies : List<Movie>)

    @Query("delete from popular_movies")
    suspend fun deleteAllMovies()

    @Query("select * from popular_movies")
    suspend fun getMovies() : List<Movie>

}