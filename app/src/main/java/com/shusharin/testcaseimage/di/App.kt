package com.shusharin.testcaseimage.di

import android.app.Application

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory().create(this)


    }
}