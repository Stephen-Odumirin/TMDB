package com.stdev.tmdb.data.db


import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Dao;
import com.stdev.tmdb.data.model.tvshow.TvShow

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShows : List<TvShow>)

    @Query("delete from popular_tv_shows")
    suspend fun deleteTvShows()

    @Query("select * from popular_tv_shows")
    suspend fun getTvShows() : List<TvShow>

}