package com.example.dashboardproject.ui.detail_screen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dashboardproject.Repository.ApiCalls
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class TSDetailScreenViewModelFactory @Inject constructor(private val mApplication: Application, private val creator: ApiCalls) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass == TSDetailScreenViewModel::class.java) {
            return TSDetailScreenViewModel(mApplication, creator) as T
        }else{
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}