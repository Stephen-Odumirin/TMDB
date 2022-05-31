package com.stdev.tmdb.data.repository

import android.util.Log
import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.data.repository.artist.datasource.ArtistCacheDataSource
import com.stdev.tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.stdev.tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.stdev.tmdb.data.repository.artist.datasourcelmpl.ArtistCacheDatasourceImpl
import com.stdev.tmdb.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistCacheDatasource: ArtistCacheDataSource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistRemoteDatasource: ArtistRemoteDatasource
) : ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newList = getArtistFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistToDB(newList)
        artistCacheDatasource.saveArtistToCache(newList)
        return newList
    }

    suspend fun getArtistFromAPI() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            val response = artistRemoteDatasource.getArtists()
            val body = response.body()
            if(body != null){
                artistList = body.artists
            }
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        return artistList
    }

    suspend fun getArtistFromDB() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistFromDB()
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromAPI()
            artistLocalDatasource.saveArtistToDB(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache() : List<Artist>{
        lateinit var artistList : List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistFromCache()
        }catch (e : Exception){
            Log.i("Tag",e.localizedMessage)
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDatasource.saveArtistToCache(artistList)
        }
        return artistList
    }
}