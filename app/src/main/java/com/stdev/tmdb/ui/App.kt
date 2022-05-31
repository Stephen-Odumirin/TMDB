package com.stdev.tmdb.ui

import android.app.Application
import com.stdev.tmdb.BuildConfig
import com.stdev.tmdb.ui.di.Injector
import com.stdev.tmdb.ui.di.artist.ArtistSubComponent
import com.stdev.tmdb.ui.di.core.*
import com.stdev.tmdb.ui.di.movie.MovieSubComponent
import com.stdev.tmdb.ui.di.tvshow.TvShowSubComponent

class App : Application(), Injector {

    private lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}