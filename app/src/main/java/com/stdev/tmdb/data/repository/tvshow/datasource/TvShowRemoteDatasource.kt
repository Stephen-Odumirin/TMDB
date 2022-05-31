package com.stdev.tmdb.data.repository.tvshow.datasource

import com.stdev.tmdb.data.api.TMBDService
import com.stdev.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {

    suspend fun getTvShowsFromAPI() : Response<TvShowList>

}