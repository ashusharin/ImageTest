package com.shusharin.testcaseimage.data.datasource.remote

import com.shusharin.testcaseimage.data.api.ApiClient
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val apiClient: ApiClient) : RemoteDataSource {
    override suspend fun getImage(): Response<List<String>> {
        return apiClient.getAllImage()
    }


}