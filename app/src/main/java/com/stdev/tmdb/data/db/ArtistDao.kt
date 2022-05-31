package com.stdev.tmdb.data.db

import androidx.room.*
import com.stdev.tmdb.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists : List<Artist>)

    @Query("delete from popular_artists")
    suspend fun deleteAllArtist()

    @Query("select * from popular_artists")
    suspend fun getArtists(): List<Artist>


}