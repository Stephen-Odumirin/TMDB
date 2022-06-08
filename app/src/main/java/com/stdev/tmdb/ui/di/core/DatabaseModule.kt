package com.stdev.tmdb.ui.di.core

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import com.stdev.tmdb.data.db.ArtistDao
import com.stdev.tmdb.data.db.MovieDao
import com.stdev.tmdb.data.db.TMDBDatabase
import com.stdev.tmdb.data.db.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context : Context) : TMDBDatabase{
        return Room.databaseBuilder(context,TMDBDatabase::class.java,"tmdbClient")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase) : MovieDao{
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase) : TvShowsDao{
        return tmdbDatabase.tvDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase) : ArtistDao{
        return tmdbDatabase.artistDao()
    }




}