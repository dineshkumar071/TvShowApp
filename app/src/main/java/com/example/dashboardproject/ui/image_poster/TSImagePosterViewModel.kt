package com.example.dashboardproject.ui.image_poster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.dashboardproject.Repository.ApiCalls
import javax.inject.Inject

class TSImagePosterViewModel @Inject constructor(private val mApplication: Application,private val apiCalls: ApiCalls) : AndroidViewModel(mApplication){
}