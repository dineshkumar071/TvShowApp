package com.example.dashboardproject.ui.detail_screen

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

class TSDetailScreenViewModel @Inject constructor(private val mApplication: Application, private val apiCall:ApiCalls):AndroidViewModel(mApplication) {
  val similarShowsLiveData by lazy { MutableLiveData<TSResponse<Trending>>() }

  fun getSimilarShow(){
      val call = apiCall.getSimilarTvShow()
      call.enqueue(object : Callback<Trending>{
          override fun onResponse(call: Call<Trending>, response: Response<Trending>) {
             if(response.isSuccessful){
                similarShowsLiveData.postValue(TSResponse.success(response.body()))
             }else{
                similarShowsLiveData.postValue(TSResponse.error(response.message()))
             }
          }

          override fun onFailure(call: Call<Trending>, t: Throwable) {
              similarShowsLiveData.postValue(TSResponse.error(t.message.toString()))
          }
      })
  }
}