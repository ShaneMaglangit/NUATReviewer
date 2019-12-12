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
        _currentQuestion.value = selectedQuestion
    }
}