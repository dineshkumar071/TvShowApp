package com.example.dashboardproject.di.module

import com.example.dashboardproject.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeWeatherActivity():MainActivity
}