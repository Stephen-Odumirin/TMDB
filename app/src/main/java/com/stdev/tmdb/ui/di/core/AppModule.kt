package com.stdev.tmdb.ui.di.core

import android.content.Context
import com.stdev.tmdb.ui.di.artist.ArtistSubComponent
import com.stdev.tmdb.ui.di.movie.MovieSubComponent
import com.stdev.tmdb.ui.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext() : Context{
        return context.applicationContext
    }

}