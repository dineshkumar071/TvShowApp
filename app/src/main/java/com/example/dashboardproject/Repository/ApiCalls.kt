package com.example.dashboardproject.Repository

import com.example.dashboardproject.service.TSClient
import javax.inject.Inject

class ApiCalls @Inject constructor(private val client : TSClient)  {
    fun getTrending()= client.getTrending()

    fun getSearchShows() = client.getSearchedShows()

    fun getSimilarTvShow() = client.getSimilarTvShow()
}