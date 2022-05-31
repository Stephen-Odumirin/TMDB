package com.stdev.tmdb.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.stdev.tmdb.domain.usecase.GetMoviesUseCase
import com.stdev.tmdb.domain.usecase.UpdateMoviesUseCase

class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData{
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.excecute()
        emit(movieList)
    }

}