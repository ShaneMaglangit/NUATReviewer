package com.shanemaglangit.nuatreviewer.ui.topic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*
import timber.log.Timber

class TopicViewModel(val database: TopicDatabaseDao, subject: String) : ViewModel() {
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _topics = MutableLiveData<List<Topic>>()
    val topics: LiveData<List<Topic>>
        get() = _topics

    init {
        uiScope.launch {
            _topics.value = getAllTopics(subject)
            Timber.d("Topics: ${_topics.value?.size ?: 0}")
        }
    }

    private suspend fun getAllTopics(subject: String) : List<Topic> {
        return withContext(Dispatchers.IO) {
            database.getAllTopicBySubject(subject)

        }
    }
}