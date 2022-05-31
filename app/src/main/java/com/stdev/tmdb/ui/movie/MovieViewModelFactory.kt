package com.stdev.tmdb.ui.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stdev.tmdb.domain.usecase.GetMoviesUseCase
import com.stdev.tmdb.domain.usecase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MoviesViewModel(getMoviesUseCase, updateMoviesUseCase) as T
    }
}