package com.shanemaglangit.nuatreviewer.ui.question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao

class QuestionViewModelFactory(private val database: TopicDatabaseDao, private val topicId: Long) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuestionViewModel::class.java)) {
            return QuestionViewModel(database, topicId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}