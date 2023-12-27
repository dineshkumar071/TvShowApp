package com.example.dashboardproject.service

import com.example.dashboardproject.Repository.Model.Trending
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TSClient {

    @GET("/3/trending/get-trending")
    fun getTrending():Call<Trending>

    @GET("/3/search/search-tv-shows")
    fun getSearchedShows(@Query("iso_country") isoCountry:String):Call<Trending>

    @GET("/3/tv/get-similar-tv-shows")
    fun getSimilarTvShow():Call<Trending>
}