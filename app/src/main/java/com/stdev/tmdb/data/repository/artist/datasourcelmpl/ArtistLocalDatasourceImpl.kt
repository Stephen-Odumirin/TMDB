package com.stdev.tmdb.data.repository.artist.datasourcelmpl

import com.stdev.tmdb.data.db.ArtistDao
import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao) : ArtistLocalDatasource {
    override suspend fun getArtistFromDB(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistToDB(artist : List<Artist>) {
        CoroutineScope(IO).launch {
            artistDao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}