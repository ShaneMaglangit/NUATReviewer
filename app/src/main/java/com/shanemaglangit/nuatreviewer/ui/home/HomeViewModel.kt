package com.shanemaglangit.nuatreviewer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.shanemaglangit.nuatreviewer.data.Topic
import timber.log.Timber

class HomeViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _topicItem = MutableLiveData<List<Topic>>()
    val topicItem: LiveData<List<Topic>>
        get() = _topicItem

    private val _selectedTopic = MutableLiveData<Topic>()
    val selectedTopic: LiveData<Topic>
        get() = _selectedTopic

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

    fun openTopic(topic: Topic) {
        _selectedTopic.value = topic
    }

    fun topicOpened() {
        _selectedTopic.value = null
    }
}