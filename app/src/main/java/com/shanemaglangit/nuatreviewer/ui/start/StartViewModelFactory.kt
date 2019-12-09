package com.shanemaglangit.nuatreviewer.ui.start

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanemaglangit.nuatreviewer.ui.start.StartViewModel

class StartViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StartViewModel::class.java)) {
            return StartViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}