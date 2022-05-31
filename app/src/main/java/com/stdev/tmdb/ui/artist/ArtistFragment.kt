package com.stdev.tmdb.ui.artist

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
import com.stdev.tmdb.databinding.FragmentArtistBinding
import com.stdev.tmdb.ui.di.Injector
import javax.inject.Inject

class ArtistFragment : Fragment() {

    private lateinit var binding : FragmentArtistBinding
    private lateinit var adapter: ArtistAdapter
    private lateinit var viewModel : ArtistViewModel
    @Inject
    lateinit var factory: ArtistsViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_artist,container,false)
        return binding.root
        //return inflater.inflate(R.layout.fragment_artist,container,false)
    }

    private fun initRecyclerView(){
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayArtists()
    }

    private fun displayArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseLiveData = viewModel.getArtists()
        responseLiveData.observe(viewLifecycleOwner) {
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
            }else{
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"No data available",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateArtists(){
        binding.artistProgressBar.visibility = View.VISIBLE
        val response = viewModel.updateArtists()
        response.observe(viewLifecycleOwner){
            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.artistProgressBar.visibility = View.GONE
                Toast.makeText(requireContext(),"Error",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as Injector).createArtistSubComponent().inject(this)

        viewModel = ViewModelProvider(this,factory)[ArtistViewModel::class.java]

        initRecyclerView()

        binding.artistUpdate.setOnClickListener {
            updateArtists()
        }

    }

}