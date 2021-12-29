package com.shusharin.testcaseimage.data.repository

import android.util.Log
import com.shusharin.testcaseimage.data.datasource.remote.RemoteDataSource
import com.shusharin.testcaseimage.domain.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : AppRepository {

    override fun getImage(): Flow<List<String>> = flow {
        val listImage = mutableListOf<String>()

        try {
           val response = remoteDataSource.getImage()
            if (response.isSuccessful){
                response.body()?.forEach{
                    listImage.add(it)
                }
            }
            emit(listImage)
        } catch (e: Exception) {
            Log.d("getImage", "Request with error -> $e")
        }
    }
}