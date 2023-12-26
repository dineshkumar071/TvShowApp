package com.example.dashboardproject.service

import retrofit2.http.GET

interface TSClient {

    @GET("/3/trending/get-trending")
    fun getTrending()

    @GET("/3/search/search-tv-shows")
    fun getSearchedShows()

    @GET("/3/tv/get-similar-tv-shows")
    fun getSimilarTvShow()
}