package com.example.dashboardproject.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dashboardproject.ui.detail_screen.TSDetailScreenViewModel
import com.example.dashboardproject.ui.detail_screen.TSDetailScreenViewModelFactory
import com.example.dashboardproject.ui.image_poster.TSImagePosterViewModel
import com.example.dashboardproject.ui.image_poster.TSImagePosterViewModelFactory
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TSImagePosterViewModel::class)
    abstract fun provideTsImagePostViewModel(posterViewModel: TSImagePosterViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TSDetailScreenViewModel::class)
    abstract fun provideTsDetailScreenViewModel(detailScreenViewModel: TSDetailScreenViewModel):ViewModel

    @Binds
    abstract fun bindDetailScreenViewModelFactory(factory: TSDetailScreenViewModelFactory): ViewModelProvider.Factory

    @Binds
    abstract fun bindImagePosterViewModelFactory(factory: TSImagePosterViewModelFactory):ViewModelProvider.Factory
}

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)