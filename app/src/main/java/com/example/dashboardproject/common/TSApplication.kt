package com.example.dashboardproject.common

import android.app.Application
import android.content.Context

class TSApplication : Application() {
    companion object {
        @JvmStatic  var instance: TSApplication?=null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}