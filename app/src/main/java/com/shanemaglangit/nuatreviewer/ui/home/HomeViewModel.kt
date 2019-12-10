package com.shanemaglangit.nuatreviewer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.shanemaglangit.nuatreviewer.data.Topic
import timber.log.Timber

class HomeViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _toStart = MutableLiveData<Boolean>()
    val toStart: LiveData<Boolean>
        get() = _toStart

    private val _topicItem = MutableLiveData<List<Topic>>()
    val topicItem: LiveData<List<Topic>>
        get() = _topicItem

    init {
        db.collection("topics")
            .orderBy("order")
            .get()
            .addOnSuccessListener { result ->
                _topicItem.value = result.toObjects(Topic::class.java)
            }
            .addOnFailureListener { exception ->
                Timber.d("Error getting documents. $exception")
            }
    }

    fun navigateToStart() {
        _toStart.value = true
    }

    fun navigateToStartCompleted() {
        _toStart.value = false
    }
}