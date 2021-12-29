package com.shusharin.testcaseimage.data.datasource.remote

import retrofit2.Response

interface RemoteDataSource {
    suspend fun getImage(): Response<List<String>>
}