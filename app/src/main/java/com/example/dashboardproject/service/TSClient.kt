package com.example.dashboardproject.service

import com.example.dashboardproject.Repository.Model.Trending
import retrofit2.Call
import retrofit2.http.GET

interface TSClient {

    @GET("/3/trending/get-trending")
    fun getTrending():Call<Trending>

    @GET("/3/search/search-tv-shows")
    fun getSearchedShows():Call<Trending>

    @GET("/3/tv/get-similar-tv-shows")
    fun getSimilarTvShow():Call<Trending>
}