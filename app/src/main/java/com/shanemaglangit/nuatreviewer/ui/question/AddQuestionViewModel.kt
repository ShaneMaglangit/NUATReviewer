package com.shanemaglangit.nuatreviewer.ui.question

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Question
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*

class AddQuestionViewModel(private val database: TopicDatabaseDao, private val topicId: Long) :
    ViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    val question = MutableLiveData<String>()
    val answer = MutableLiveData<String>()
    val optionB = MutableLiveData<String>()
    val optionC = MutableLiveData<String>()
    val optionD = MutableLiveData<String>()

    fun saveQuestion() {
        uiScope.launch {
            insertQuestion()
        }
    }

    private suspend fun insertQuestion() {
        return withContext(Dispatchers.IO) {
            val question = Question(
                questionTopicId=topicId,
                question=question.value!!,
                answer=answer.value!!,
                options=listOf(optionB.value!!, optionC.value!!, optionD.value!!)
            )
            database.insert(question)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}