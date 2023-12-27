package com.example.dashboardproject.Repository

import com.example.dashboardproject.service.TSClient
import javax.inject.Inject

class ApiCalls @Inject constructor(private val client : TSClient)  {
    fun getTrending()= client.getTrending()

    fun getSearchShows(searchTest:String) = client.getSearchedShows(searchTest)

    fun getSimilarTvShow() = client.getSimilarTvShow()
}