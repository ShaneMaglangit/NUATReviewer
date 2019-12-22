package com.shanemaglangit.nuatreviewer.data

import androidx.room.Embedded
import androidx.room.Relation

data class TopicWithQuestion(
    @Embedded val topic: Topic,
    @Relation(
        parentColumn = "topicId",
        entityColumn = "questionTopicId"
    )
    val questions: List<Question>
)