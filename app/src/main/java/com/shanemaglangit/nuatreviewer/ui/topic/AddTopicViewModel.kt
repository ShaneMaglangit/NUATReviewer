package com.shanemaglangit.nuatreviewer.ui.topic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*

class AddTopicViewModel(val database: TopicDatabaseDao, val subject: String) : ViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    val category = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()

    fun saveTopic() {
        uiScope.launch {
            insertTopic()
        }
    }

    private suspend fun insertTopic() {
        return withContext(Dispatchers.IO) {
            val topic = Topic(
                subject=subject,
                category=category.value!!,
                title=title.value!!,
                description=description.value!!
            )
            database.insert(topic)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}