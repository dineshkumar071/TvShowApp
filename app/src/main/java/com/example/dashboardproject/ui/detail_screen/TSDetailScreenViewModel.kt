package com.example.dashboardproject.ui.detail_screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.dashboardproject.Repository.ApiCalls
import javax.inject.Inject

class TSDetailScreenViewModel @Inject constructor(private val mApplication: Application, private val apiCall:ApiCalls):AndroidViewModel(mApplication) {

}