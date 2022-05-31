package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val repository: TvShowRepository) {

    suspend fun exceute() : List<TvShow>? = repository.updateTvShows()

}