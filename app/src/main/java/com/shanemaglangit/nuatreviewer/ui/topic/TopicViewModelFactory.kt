package com.shanemaglangit.nuatreviewer.ui.topic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao

class TopicViewModelFactory(private val database: TopicDatabaseDao, private val subject: String) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TopicViewModel::class.java)) {
            return TopicViewModel(database, subject) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}