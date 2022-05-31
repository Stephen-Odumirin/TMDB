package com.stdev.tmdb.data.repository.tvshow.datasourceImpl

import com.stdev.tmdb.data.api.TMBDService
import com.stdev.tmdb.data.model.tvshow.TvShowList
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(private val tmbdService: TMBDService,private val apiKey : String) : TvShowRemoteDatasource {
    override suspend fun getTvShowsFromAPI(): Response<TvShowList> {
        return tmbdService.getPopularTv(apiKey)
    }
}