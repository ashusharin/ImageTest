package com.shusharin.testcaseimage.di

import com.shusharin.testcaseimage.data.api.ApiClient
import com.shusharin.testcaseimage.data.api.ServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RetrofitModule {

    val BASE_URL = "http://app.passport.com.ru"


    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ServiceApi {
        return retrofit.create(ServiceApi::class.java)
    }


    @Singleton
    @Provides
    fun provideApiClient(serviceApi: ServiceApi): ApiClient {
        return ApiClient(serviceApi)
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }
}