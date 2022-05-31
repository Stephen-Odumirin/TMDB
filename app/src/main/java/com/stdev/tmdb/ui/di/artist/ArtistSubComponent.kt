package com.stdev.tmdb.ui.di.artist

import com.stdev.tmdb.ui.artist.ArtistFragment
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {

    fun inject(artistFragment : ArtistFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create() : ArtistSubComponent
    }

}