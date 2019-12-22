package com.shanemaglangit.nuatreviewer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="question_table")
data class Question (
    @PrimaryKey(autoGenerate = true)
    var questionId: Long = 0L,
    var questionTopicId: Long = 0L,
    val question: String,
    val answer: String
)