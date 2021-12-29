package com.shusharin.testcaseimage.data.api

import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {

    @GET("/android-dev-task.php")
    suspend fun getImage(): Response<List<String>>
}