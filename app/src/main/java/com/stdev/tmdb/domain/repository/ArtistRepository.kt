package com.stdev.tmdb.domain.repository

import com.stdev.tmdb.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtists() : List<Artist>?
    suspend fun updateArtists() : List<Artist>?

}