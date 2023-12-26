package com.example.dashboardproject.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module
class AppModule(val mApplication : Application) {

    @Provides
    fun provideApplication():Application = mApplication

}