package com.shanemaglangit.nuatreviewer.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel(totalQuestion: Int, correctAnswers: Int) : ViewModel() {
    private val _totalQuestion = MutableLiveData<Int>(totalQuestion)
    val totalQuestion: LiveData<Int>
        get() = _totalQuestion

    private val _correctAnswers = MutableLiveData<Int>(correctAnswers)
    val correctAnswers: LiveData<Int>
        get() = _correctAnswers
}