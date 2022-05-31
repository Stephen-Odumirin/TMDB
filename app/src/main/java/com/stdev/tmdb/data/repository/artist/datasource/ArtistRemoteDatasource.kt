package com.stdev.tmdb.data.repository.artist.datasource

import com.stdev.tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtists() : Response<ArtistList>

}