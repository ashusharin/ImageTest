package com.shusharin.testcaseimage.di

import com.shusharin.testcaseimage.data.datasource.remote.RemoteDataSource
import com.shusharin.testcaseimage.data.datasource.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @Binds
    fun provideRemoteDataSource(impl: RemoteDataSourceImpl): RemoteDataSource
}