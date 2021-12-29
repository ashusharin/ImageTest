package com.shusharin.testcaseimage.di

import com.shusharin.testcaseimage.data.repository.AppRepositoryImpl
import com.shusharin.testcaseimage.domain.AppRepository
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {
    @Binds
    fun bindRepository(impl: AppRepositoryImpl): AppRepository
}