package com.shanemaglangit.nuatreviewer.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.shanemaglangit.nuatreviewer.data.Question
import timber.log.Timber
import kotlin.random.Random

class QuestionViewModel(title: String) : ViewModel() {
    val db = FirebaseFirestore.getInstance()

    private lateinit var questions: MutableList<Question>
    private var questionsCount: Int = 0
    private var correctAnswers: Int = 0
    private var incorrectAnswer: Int = 0

    private var _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    private var _optionTopLeft = MutableLiveData<String>()
    val optionTopLeft: LiveData<String>
        get() = _optionTopLeft

    private var _optionTopRight = MutableLiveData<String>()
    val optionTopRight: LiveData<String>
        get() = _optionTopRight

    private var _optionBottomLeft = MutableLiveData<String>()
    val optionBottomLeft: LiveData<String>
        get() = _optionBottomLeft

    private var _optionBottomRight = MutableLiveData<String>()
    val optionBottomRight: LiveData<String>
        get() = _optionBottomRight

    val optionTopLeftChecked = MutableLiveData<Boolean>()
    val optionTopRightChecked = MutableLiveData<Boolean>()
    val optionBottomRightChecked = MutableLiveData<Boolean>()
    val optionBottomLeftChecked = MutableLiveData<Boolean>()

    init {
        db.collection("questions")
            .whereEqualTo("topic", title.toLowerCase())
            .get()
            .addOnSuccessListener { result ->
                questions = result.toObjects(Question::class.java)
                questionsCount = questions.size
                selectRandomQuestion()
            }
            .addOnFailureListener { exception ->
                Timber.d("Error getting documents. $exception")
            }
    }

    fun selectRandomQuestion() {
        val selectedQuestion = questions[Random.nextInt(0, questionsCount)]
        val choices = selectedQuestion.options.toMutableList().apply{
            add(selectedQuestion.answer)
            shuffle()
        }

        _currentQuestion.value = selectedQuestion
        _optionTopLeft.value = choices[0]
        _optionTopRight.value = choices[1]
        _optionBottomLeft.value = choices[2]
        _optionBottomRight.value = choices[3]
    }

    fun submitAnswer() {

    }
}