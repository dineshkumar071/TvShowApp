package com.example.dashboardproject.common

import android.app.Application
import android.content.Context
import com.example.dashboardproject.di.component.AppComponent
import com.example.dashboardproject.di.component.DaggerAppComponent
import com.example.dashboardproject.di.module.ApiModule
import com.example.dashboardproject.di.module.AppModule

class TSApplication : Application() {

    private lateinit var mAppComponent: AppComponent
    companion object {
        @JvmStatic  var instance: TSApplication?=null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        mAppComponent = DaggerAppComponent.builder().appModule(AppModule(this)).apiModule(ApiModule("https://developer.themoviedb.org/")).build()
    }

    public fun getComponent():AppComponent = mAppComponent
}