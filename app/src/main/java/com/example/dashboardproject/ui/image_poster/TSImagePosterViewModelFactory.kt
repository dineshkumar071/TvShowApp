package com.example.dashboardproject.ui.image_poster

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dashboardproject.Repository.ApiCalls
import javax.inject.Inject

class TSImagePosterViewModelFactory @Inject constructor(private val mApplication: Application, private val creator: ApiCalls) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == TSImagePosterViewModel::class.java) {
            return TSImagePosterViewModel(mApplication, creator) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}