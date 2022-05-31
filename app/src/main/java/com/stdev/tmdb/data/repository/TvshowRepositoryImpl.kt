package com.stdev.tmdb.data.repository

import android.util.Log
import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.stdev.tmdb.domain.repository.TvShowRepository

class TvshowRepositoryImpl(
    private val tvShowCacheDatasource : TvShowCacheDataSource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowRemoteDatasource: TvShowRemoteDatasource
) : TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newList = getTvShowsFromAPI()
        tvShowLocalDatasource.clearAll()
        tvShowLocalDatasource.saveTvShowsToDB(newList)
        tvShowCacheDatasource.saveTvShowsToCache(newList)
        return newList
    }

    suspend fun getTvShowsFromAPI() : List<TvShow>{

        lateinit var tvShows : List<TvShow>
        try {
            val response = tvShowRemoteDatasource.getTvShowsFromAPI()
            val body = response.body()
            if(body!=null){
                tvShows = body.tvShows
            }
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        return tvShows
    }

    suspend fun getTvShowsFromDB() : List<TvShow>{

        lateinit var tvShows : List<TvShow>
        try {
            tvShows = tvShowLocalDatasource.getTvShowsFromDB()
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        if(tvShows.isNotEmpty()){
            return tvShows
        }else{
            tvShows = getTvShowsFromAPI()
            tvShowLocalDatasource.saveTvShowsToDB(tvShows)
        }

        return tvShows

    }

    suspend fun getTvShowsFromCache() : List<TvShow>{

        lateinit var tvShows : List<TvShow>
        try {
            tvShows = tvShowCacheDatasource.getTvShowsFromCache()
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        if (tvShows.isNotEmpty()){
            return tvShows
        }else{
            tvShows = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShows)
        }
        return tvShows
    }

}