package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.domain.repository.ArtistRepository

class UpdateArtistsUseCase(private val repository: ArtistRepository) {
    suspend fun execute() : List<Artist>? = repository.updateArtists()
}