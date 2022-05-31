package com.stdev.tmdb.ui.tv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stdev.tmdb.R
import com.stdev.tmdb.data.model.tvshow.TvShow
import com.stdev.tmdb.databinding.ListItemBinding

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.MyViewHolder>() {

    private val tvList = ArrayList<TvShow>()

    fun setList(tvshows : List<TvShow>){
        tvList.clear()
        tvList.addAll(tvshows)
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(tvShow: TvShow){
                binding.listTitle.text = tvShow.name
                binding.listDescription.text = tvShow.overview
                val posterUrl = "https://image.tmdb.org/t/p/original" + tvShow.posterPath
                Log.i("Adapter",posterUrl)
                Glide.with(binding.listImage.context)
                    .load(posterUrl)
                    .into(binding.listImage)
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(tvList[position])
    }

    override fun getItemCount(): Int {
        return tvList.size
    }

}