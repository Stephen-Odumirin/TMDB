package com.stdev.tmdb.data.api

import com.stdev.tmdb.data.model.artist.ArtistList
import com.stdev.tmdb.data.model.movie.MovieList
import com.stdev.tmdb.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface TMBDService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String) : Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTv(@Query("api_key") apiKey : String) : Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtist(@Query("api_key") apiKey : String) : Response<ArtistList>

}