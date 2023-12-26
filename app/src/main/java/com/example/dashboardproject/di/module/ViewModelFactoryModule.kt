package com.example.dashboardproject.di.module

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.example.dashboardproject.Repository.ApiCalls
import com.example.dashboardproject.ui.detail_screen.TSDetailScreenViewModelFactory
import com.example.dashboardproject.ui.image_poster.TSImagePosterViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ViewModelFactoryModule {

    @Provides
    @Singleton
    @Named("Details-screen")
    fun provideTsDetailScreenViewModelFactory(mApplication: Application, apiCall: ApiCalls): ViewModelProvider.Factory{
        return  TSDetailScreenViewModelFactory(mApplication,apiCall)
    }

    @Provides
    @Singleton
    @Named("Image-poster")
    fun provideTsImageProviderViewModelFactory(mApplication: Application,apiCall: ApiCalls):ViewModelProvider.Factory{
        return TSImagePosterViewModelFactory(mApplication,apiCall)
    }
}