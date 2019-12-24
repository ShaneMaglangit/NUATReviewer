package com.shanemaglangit.nuatreviewer.ui.topic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Topic
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*

class TopicViewModel(val database: TopicDatabaseDao, subject: String) : ViewModel() {
    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _topics = MutableLiveData<List<Topic>>()
    val topics: LiveData<List<Topic>>
        get() = _topics

    private val _categories = MutableLiveData<List<String>>()
    val categories: LiveData<List<String>>
        get() = _categories

    init {
        uiScope.launch {
            _categories.value = getCategoriesBySubject(subject)
        }
    }

    fun loadTopics(category: String? = null) {
        uiScope.launch {
            _topics.value = getTopicsByCategory(category ?: _categories.value!![0])
        }
    }

    private suspend fun getCategoriesBySubject(subject: String) : List<String> {
        return withContext(Dispatchers.IO) {
            database.getCategoryBySubject(subject)
        }
    }

    private suspend fun getTopicsByCategory(category: String) : List<Topic> {
        return withContext(Dispatchers.IO) {
            database.getTopicIdAndTitleByCategory(category)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}