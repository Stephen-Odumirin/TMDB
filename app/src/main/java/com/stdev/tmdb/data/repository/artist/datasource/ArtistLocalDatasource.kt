package com.stdev.tmdb.data.repository.artist.datasource

import com.stdev.tmdb.data.model.artist.Artist

interface ArtistLocalDatasource {

    suspend fun getArtistFromDB() : List<Artist>
    suspend fun saveArtistToDB(artist : List<Artist>)
    suspend fun clearAll()

}