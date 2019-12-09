package com.shanemaglangit.nuatreviewer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Topic

class HomeViewModel : ViewModel() {
    private val _toStart = MutableLiveData<Boolean>()
    val toStart: LiveData<Boolean>
        get() = _toStart

    private val _topicItem = MutableLiveData<List<Topic>>(
        listOf(
            Topic(title="Operations"),
            Topic(title="Decimals"),
            Topic(title="Fractions")
        )
    )
    val topicItem: LiveData<List<Topic>>
        get() = _topicItem

    fun navigateToStart() {
        _toStart.value = true
    }

    fun navigateToStartCompleted() {
        _toStart.value = false
    }
}