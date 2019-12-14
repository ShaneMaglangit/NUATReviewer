package com.shanemaglangit.nuatreviewer.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanemaglangit.nuatreviewer.ui.result.ResultViewModel

class ResultViewModelFactory(private val totalQuestion: Int, private val correctAnswers: Int) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            return ResultViewModel(totalQuestion, correctAnswers) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}