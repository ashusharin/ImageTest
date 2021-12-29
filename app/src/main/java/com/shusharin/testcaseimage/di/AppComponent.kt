package com.shusharin.testcaseimage.di

import android.app.Application
import com.shusharin.testcaseimage.ui.main.MainActivity
import com.shusharin.testcaseimage.ui.mainscreen.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetrofitModule::class, DomainModule::class, ViewModelModule::class, DataModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)

    @Component.Factory
    interface AppComponentFactory {
        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }
}
