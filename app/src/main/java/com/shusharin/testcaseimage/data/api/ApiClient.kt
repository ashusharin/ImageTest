package com.shusharin.testcaseimage.data.api

import retrofit2.Response
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ServiceApi) {

    suspend fun getAllImage(): Response<List<String>> {
        return apiService.getImage()
    }
}