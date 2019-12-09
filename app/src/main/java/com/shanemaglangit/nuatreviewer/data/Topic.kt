package com.shanemaglangit.nuatreviewer.data

import androidx.room.PrimaryKey

data class Topic (
    @PrimaryKey(autoGenerate=true)
    val id: Long = 0L,
    val title: String,
    val description: String? = null
)