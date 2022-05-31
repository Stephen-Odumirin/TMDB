package com.stdev.tmdb.data.repository.artist.datasourcelmpl

import com.stdev.tmdb.data.api.TMBDService
import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.data.model.artist.ArtistList
import com.stdev.tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(private val tmdbService : TMBDService,private val apiKey : String) : ArtistRemoteDatasource {
    override suspend fun getArtists(): Response<ArtistList> {
            return tmdbService.getPopularArtist(apiKey)
    }
}