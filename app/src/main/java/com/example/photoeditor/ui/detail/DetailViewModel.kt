package com.example.photoeditor.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {


    var _isFilterApplied: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFilterApplied: StateFlow<Boolean>
        get() = _isFilterApplied

}