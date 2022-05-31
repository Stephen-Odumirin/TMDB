package com.stdev.tmdb.ui.movie

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stdev.tmdb.R
import com.stdev.tmdb.data.model.movie.Movie
import com.stdev.tmdb.databinding.ListItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    private val movieList = ArrayList<Movie>()

    fun setList(movies : List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }

    class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(movie : Movie){
            binding.listTitle.text = "${movie.title}"
            binding.listDescription.text = "${movie.overview}"
            val posterUrl = "https://image.tmdb.org/t/p/original" + movie.posterPath
            Log.i("Adapter",posterUrl)
            Glide.with(binding.listImage.context)
                .load(posterUrl)
                .into(binding.listImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}