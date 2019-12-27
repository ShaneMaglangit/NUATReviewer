package com.shanemaglangit.nuatreviewer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topic_table")
data class Topic(
    @PrimaryKey(autoGenerate = true)
    var topicId: Long = 0L,
    val subject: String?,
    val category: String?,
    val title: String?,
    val description: String?
)