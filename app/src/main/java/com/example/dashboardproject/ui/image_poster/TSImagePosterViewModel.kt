package com.example.dashboardproject.ui.image_poster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.dashboardproject.Repository.ApiCalls
import com.example.dashboardproject.Repository.Model.Trending
import com.example.dashboardproject.Repository.TSResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TSImagePosterViewModel @Inject constructor(
    private val mApplication: Application,
    private val apiCalls: ApiCalls
) : AndroidViewModel(mApplication) {

    val trendingLiveData by lazy { MutableLiveData<TSResponse<Trending>>() }
    val searchedTrends by lazy { MutableLiveData<TSResponse<Trending>>() }

    /**This method is used to fetch the trending list*/
    fun getTrending() {
        val call = apiCalls.getTrending()
        call.enqueue(object : Callback<Trending> {
            override fun onResponse(call: Call<Trending>, response: Response<Trending>) {
                if (response.isSuccessful) {
                    trendingLiveData.postValue(TSResponse.success(response.body()))
                } else {
                    // we need to handle the scenario based on the status code
                    trendingLiveData.postValue(TSResponse.error(response.message()))
                }
            }

            override fun onFailure(call: Call<Trending>, t: Throwable) {
                trendingLiveData.postValue(TSResponse.error(t.message.toString()))
            }
        })
    }

    /** This method is used to fetch the searched trending list.*/
    fun getSearchShows() {
        val call = apiCalls.getSearchShows()
        call.enqueue(object : Callback<Trending> {
            override fun onResponse(call: Call<Trending>, response: Response<Trending>) {
                if (response.isSuccessful) {
                    searchedTrends.postValue(TSResponse.success(response.body()))
                } else {
                    searchedTrends.postValue(TSResponse.error(response.message()))
                }
            }

            override fun onFailure(call: Call<Trending>, t: Throwable) {
                searchedTrends.postValue(TSResponse.error(t.message.toString()))
            }
        })
    }
}