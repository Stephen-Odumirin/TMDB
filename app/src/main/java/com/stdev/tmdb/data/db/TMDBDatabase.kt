package com.stdev.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.data.model.tvshow.TvShow

@Database(entities = [Movie::class,TvShow::class,Artist::class],
version = 2,
exportSchema = false)

abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun tvDao() : TvShowsDao
    abstract fun artistDao() : ArtistDao

}