package com.example.dashboardproject.ui.detail_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dashboardproject.Repository.Model.Results
import com.example.dashboardproject.Repository.Model.Trending
import com.example.dashboardproject.databinding.AdapterSimilarShowsBinding

class TSSimilarShowsAdapter(private val mContext: Context,private val similarShows: MutableList<Results>,private val showSimilarShowClickListener: ShowSimilarShowClickListener):RecyclerView.Adapter<TSSimilarShowsAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: AdapterSimilarShowsBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterSimilarShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = similarShows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(similarShows[position]){
                Glide.with(mContext).load(this.posterPath).into(binding.ivSimilarShow)
                binding.ivSimilarShow.setOnClickListener {
                    showSimilarShowClickListener.onClickSimilarShows(position,this)
                }
            }
        }
    }

    fun interface ShowSimilarShowClickListener{
        fun onClickSimilarShows(position: Int, trend:Results)
    }
}