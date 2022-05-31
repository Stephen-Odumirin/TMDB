package com.stdev.tmdb.ui.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stdev.tmdb.domain.usecase.GetTvShowUseCase
import com.stdev.tmdb.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }

}