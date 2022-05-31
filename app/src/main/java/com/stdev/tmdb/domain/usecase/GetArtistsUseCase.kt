package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.domain.repository.ArtistRepository

class GetArtistsUseCase(private val repository: ArtistRepository) {

    suspend fun execute() : List<Artist>? = repository.getArtists()

}