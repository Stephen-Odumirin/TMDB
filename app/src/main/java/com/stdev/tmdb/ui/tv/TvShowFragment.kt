package com.stdev.tmdb.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.stdev.tmdb.R
import com.stdev.tmdb.databinding.FragmentTvShowsBinding
import com.stdev.tmdb.ui.di.Injector
import javax.inject.Inject

class TvShowFragment : Fragment() {

    private lateinit var binding : FragmentTvShowsBinding
    @Inject
    lateinit var factory : TvShowViewModelFactory
    private lateinit var viewModel : TvShowViewModel
    private lateinit var adapter : TvShowAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_tv_shows,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_tv_shows,container,false)
    }

    private fun initRecyclerView(){

        binding.tvRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = TvShowAdapter()
        binding.tvRecyclerView.adapter = adapter
        displayTvShows()

    }

    private fun displayTvShows() {
        binding.tvProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getTvShows()
        responseLiveData.observe(viewLifecycleOwner){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }else{
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"No data available",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateArtists(){
        binding.tvProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateTvShows()
        response.observe(viewLifecycleOwner){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.tvProgressBar.visibility = View.GONE
            }else{
                binding.tvProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as Injector).createTvShowSubComponent().inject(this)

        viewModel = ViewModelProvider(this,factory)[TvShowViewModel::class.java]

        initRecyclerView()

        binding.tvUpdate.setOnClickListener {
            updateArtists()
        }

    }


}