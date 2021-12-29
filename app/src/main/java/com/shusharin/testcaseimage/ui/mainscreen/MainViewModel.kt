package com.shusharin.testcaseimage.ui.mainscreen

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import com.shusharin.testcaseimage.domain.GetImageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getImageUseCase: GetImageUseCase) :
    ViewModel() {

    private var _needUpdate: MutableStateFlow<Unit> = MutableStateFlow(Unit)
    var listImage = _needUpdate.flatMapLatest {
        getImageUseCase()
    }

    fun updateList() {
        _needUpdate.value = Unit
        Log.d("Updatelist", " update")
    }

}
