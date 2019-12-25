package com.shanemaglangit.nuatreviewer.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shanemaglangit.nuatreviewer.data.Question
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import kotlinx.coroutines.*
import kotlin.random.Random

class QuestionViewModel(private val database: TopicDatabaseDao, private val topicId: Long) :
    ViewModel() {
    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    private val _question = MutableLiveData<MutableList<Question>>()
    val question: LiveData<MutableList<Question>>
        get() = _question

    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    private val _testDone = MutableLiveData<Boolean>()
    val testDone: LiveData<Boolean>
        get() = _testDone

    var totalQuestions = 0
    var correctAnswers = 0

    init {
        uiScope.launch {
            _question.value = getQuestionsByTopicId(topicId)
        }
    }

    fun calculateTotalQuestions() {
        totalQuestions = _question.value!!.size
    }

    fun loadOptions(): MutableList<String> =
        _currentQuestion.value!!.options.toMutableList().apply {
            add(_currentQuestion.value!!.answer)
        }

    fun loadQuestion() : Boolean {
        if(_question.value!!.size > 0) {
            val questionIndex = Random.nextInt(_question.value!!.size)

            _currentQuestion.value = _question.value!![questionIndex]
            _question.value?.removeAt(questionIndex)
        } else {
            _testDone.value = true
        }

        return _testDone.value ?: false
    }

    fun testDoneCompleted() {
        _testDone.value = false
    }

    fun answerCorrect() {
        correctAnswers++
    }

    private suspend fun getQuestionsByTopicId(topicId: Long): MutableList<Question> {
        return withContext(Dispatchers.IO) {
            database.getQuestionsByTopicId(topicId)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}