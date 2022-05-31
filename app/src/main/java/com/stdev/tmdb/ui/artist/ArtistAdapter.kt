package com.stdev.tmdb.ui.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.stdev.tmdb.R
import com.stdev.tmdb.data.model.artist.Artist
import com.stdev.tmdb.databinding.ListItemBinding

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.MyViewHolder>() {

    private val artistList = ArrayList<Artist>()

    fun setList(artists : List<Artist>){
        artistList.clear()
        artistList.addAll(artists)
    }

    class MyViewHolder(val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bindData(artist: Artist){
            binding.listTitle.text = artist.name
            binding.listDescription.text = artist.knownForDepartment
            val posterUrl = "https://image.tmdb.org/t/p/original" + artist.profilePath
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
        holder.bindData(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }
}