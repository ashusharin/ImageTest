package com.shusharin.testcaseimage.domain

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getImage(): Flow<List<String>>
}