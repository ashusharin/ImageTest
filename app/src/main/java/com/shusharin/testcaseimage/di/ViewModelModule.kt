package com.shusharin.testcaseimage.di

import androidx.lifecycle.ViewModel
import com.shusharin.testcaseimage.ui.mainscreen.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    fun bindMainViewModel(impl: MainViewModel): ViewModel
}