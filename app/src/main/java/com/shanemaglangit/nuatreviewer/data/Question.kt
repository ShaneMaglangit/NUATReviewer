package com.shanemaglangit.nuatreviewer.data

import com.google.firebase.firestore.DocumentId

class Question (
    @DocumentId
    val questionId: String = "",
    val topic: String = "",
    val question: String = "",
    val answer: String = "",
    val options: List<String> = listOf()
)