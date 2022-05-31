package com.stdev.tmdb.data.repository.tvshow.datasourceImpl

import com.stdev.tmdb.data.db.TvShowsDao
import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowsDao: TvShowsDao) : TvShowLocalDatasource {
    override suspend fun getTvShowsFromDB(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            tvShowsDao.deleteTvShows()
        }
    }
}