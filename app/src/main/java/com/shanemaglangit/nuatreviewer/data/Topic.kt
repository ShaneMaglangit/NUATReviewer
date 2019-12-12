package com.shanemaglangit.nuatreviewer.data

import com.google.firebase.firestore.DocumentId

data class Topic (
    @DocumentId
    val topicId: String = "",
    val category: String? = null,
    val title: String? = null,
    val description: String? = null,
    val order: Int = 0
)