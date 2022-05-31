package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.ui.di.artist.ArtistSubComponent
import com.stdev.tmdb.ui.di.movie.MovieSubComponent
import com.stdev.tmdb.ui.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DatabaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent() : MovieSubComponent.Factory
    fun tvShowSubComponent() : TvShowSubComponent.Factory
    fun artistSubComponent() : ArtistSubComponent.Factory

}