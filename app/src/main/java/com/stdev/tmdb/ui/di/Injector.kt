package com.stdev.tmdb.ui.di

import com.stdev.tmdb.ui.di.artist.ArtistSubComponent
import com.stdev.tmdb.ui.di.movie.MovieSubComponent
import com.stdev.tmdb.ui.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent() : MovieSubComponent
    fun createTvShowSubComponent() : TvShowSubComponent
    fun createArtistSubComponent() : ArtistSubComponent

}