package com.stdev.tmdb.ui.di.tvshow

import com.stdev.tmdb.ui.artist.ArtistFragment
import com.stdev.tmdb.ui.tv.TvShowFragment
import dagger.Subcomponent

@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {

    fun inject(tvShowFragment : TvShowFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : TvShowSubComponent
    }

}