package com.stdev.tmdb.ui.di.movie

import com.stdev.tmdb.ui.artist.ArtistFragment
import com.stdev.tmdb.ui.movie.MoviesFragment
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieFragment : MoviesFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : MovieSubComponent
    }

}