package com.example.dashboardproject.ui.detail_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dashboardproject.Repository.Model.Trending
import com.example.dashboardproject.databinding.AdapterSimilarShowsBinding

class TSSimilarShowsAdapter(private val mContext: Context,private val similarShows: MutableList<Trending>,private val showSimilarShowClickListener: ShowSimilarShowClickListener):RecyclerView.Adapter<TSSimilarShowsAdapter.ViewHolder>() {
    inner class ViewHolder(binding: AdapterSimilarShowsBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AdapterSimilarShowsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = similarShows.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){/*
            with(languageList[position]){
                binding.tvLangName.text = this.name
                binding.tvExp.text = this.exp
            }*/
        }
    }

    interface ShowSimilarShowClickListener{
        fun onClickSimilarShows(position: Int, trend:Trending)
    }
}