package com.shanemaglangit.nuatreviewer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topic_table")
data class Topic (
    @PrimaryKey(autoGenerate=true)
    val topicId: Long = 0L,
    val category: String? = null,
    val title: String? = null,
    val description: String? = null,
    val order: Int? = 0
)