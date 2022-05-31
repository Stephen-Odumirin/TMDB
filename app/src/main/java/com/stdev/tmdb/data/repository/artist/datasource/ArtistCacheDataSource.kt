package com.stdev.tmdb.data.repository.artist.datasource

import com.stdev.tmdb.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistFromCache() : List<Artist>
    suspend fun saveArtistToCache(artists : List<Artist>)
}