package com.stdev.tmdb.ui.movie

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stdev.tmdb.R
import com.stdev.tmdb.databinding.FragmentMoviesBinding
import com.stdev.tmdb.ui.di.Injector
import javax.inject.Inject

class MoviesFragment : Fragment() {

    private lateinit var binding : FragmentMoviesBinding
    @Inject
    lateinit var factory : MovieViewModelFactory
    private lateinit var movieViewModel : MoviesViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movies,container,false)
        return binding.root
    }

    private fun initRecyclerView(){
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayMovies()
    }

    private fun displayMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"No data available",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateMovies(){
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            } else {
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this,factory)[MoviesViewModel::class.java]

        initRecyclerView()

        binding.movieUpdate.setOnClickListener {
            updateMovies()
        }


    }

}