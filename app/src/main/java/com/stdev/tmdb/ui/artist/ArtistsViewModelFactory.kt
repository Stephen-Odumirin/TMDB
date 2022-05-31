package com.stdev.tmdb.ui.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stdev.tmdb.domain.usecase.GetArtistsUseCase
import com.stdev.tmdb.domain.usecase.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistViewModel(getArtistsUseCase, updateArtistsUseCase) as T
    }

}