package com.example.dashboardproject.ui.image_poster

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.Repository.Model.Trending
import com.example.dashboardproject.databinding.AdapterImagePosterBinding

class TSImagePosterAdapter(private val mContext: Context,
                           private val shows :MutableList<Results>,
                           private val imagePosterClickListener: ImagePosterClickListener) : RecyclerView.Adapter<TSImagePosterAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterImagePosterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterImagePosterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = shows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(shows[position]){
                Glide.with(mContext).load(this.posterPath).into(binding.ivPoster)
                binding.tvPosterTitle.text = this.title
                binding.clContainsTrends.setOnClickListener {
                    imagePosterClickListener.posterOnClickListener(position,this)
                }
            }
        }
    }

    fun interface ImagePosterClickListener {
        fun posterOnClickListener(position: Int, trend:Results)
    }
}