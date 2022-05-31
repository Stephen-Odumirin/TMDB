package com.stdev.tmdb.data.repository.artist.datasourcelmpl

import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDatasourceImpl : ArtistCacheDataSource {

    private var artistList = ArrayList<Artist>()

    override suspend fun getArtistFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}