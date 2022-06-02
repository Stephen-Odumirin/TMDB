package com.stdev.tmdb.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.stdev.tmdb.data.db.repository.movie.FakeMovieRepository
import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.domain.usecase.GetMoviesUseCase
import com.stdev.tmdb.domain.usecase.UpdateMoviesUseCase
import com.stdev.tmdb.getOrAwaitValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MoviesViewModelTest{

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp(){

        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MoviesViewModel(getMoviesUseCase, updateMoviesUseCase)

    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1,"overview1","path1","title1"))
        movies.add(Movie(2,"overview2","path2","title2"))
        movies.add(Movie(3,"overview3","path3","title3"))
        movies.add(Movie(4,"overview4","path4","title4"))
        movies.add(Movie(5,"overview5","path5","title5"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(11,"overview11","path11","title11"))
        movies.add(Movie(12,"overview12","path12","title12"))
        movies.add(Movie(13,"overview13","path13","title13"))
        movies.add(Movie(14,"overview14","path14","title14"))
        movies.add(Movie(15,"overview15","path15","title15"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }

}