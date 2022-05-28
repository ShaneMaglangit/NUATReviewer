package com.shanemaglangit.nuatreviewer.ui.lesson

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao

class LessonViewModelFactory(private val database: TopicDatabaseDao, private val topicId: Long) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LessonViewModel::class.java)) {
            return LessonViewModel(database, topicId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}