package com.stdev.tmdb.ui.di.core

import com.stdev.tmdb.data.api.TMBDService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl : String) {

    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit{

        val interceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(interceptor)
        }.build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideTMDBService (retrofit: Retrofit) : TMBDService{
        return retrofit.create(TMBDService::class.java)
    }

}