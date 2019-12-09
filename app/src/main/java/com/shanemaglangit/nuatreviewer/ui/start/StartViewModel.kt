package com.shanemaglangit.nuatreviewer.ui.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StartViewModel : ViewModel() {
    private val _toQuestion = MutableLiveData<Boolean>()
    val toQuestion: LiveData<Boolean>
        get() = _toQuestion
    
    private val _toHome = MutableLiveData<Boolean>()
    val toHome: LiveData<Boolean>
        get() = _toHome
    
    fun navigatetoQuestion() {
        _toQuestion.value = true
    }
    
    fun navigatetoQuestionCompleted() {
        _toQuestion.value = false
    }
    
    fun navigateToHome() {
        _toHome.value = true
    }
    
    fun navigateToHomeCompleted() {
        _toHome.value = false
    }
}