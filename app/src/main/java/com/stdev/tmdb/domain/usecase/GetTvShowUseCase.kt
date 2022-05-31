package com.stdev.tmdb.domain.usecase

import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.domain.repository.TvShowRepository

class GetTvShowUseCase(private val repository: TvShowRepository) {

    suspend fun excuete() : List<TvShow>? = repository.getTvShows()

}