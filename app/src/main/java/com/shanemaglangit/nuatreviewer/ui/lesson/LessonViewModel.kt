package com.shanemaglangit.nuatreviewer.ui.lesson

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*

class LessonViewModel(private val database: TopicDatabaseDao, topicId: Long) : ViewModel() {
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _topic = MutableLiveData<Topic>()
    val topic: LiveData<Topic>
        get() = _topic

    init {
        uiScope.launch {
            _topic.value = getTopic(topicId)
        }
    }

    private suspend fun getTopic(topicId: Long): Topic {
        return withContext(Dispatchers.IO) {
            database.getTopic(topicId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}