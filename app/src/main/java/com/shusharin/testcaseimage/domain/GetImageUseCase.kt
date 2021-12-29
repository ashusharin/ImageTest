package com.shusharin.testcaseimage.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetImageUseCase @Inject constructor(private val appRepository: AppRepository) {

    operator fun invoke(): Flow<List<String>> {
        return appRepository.getImage()
    }
}