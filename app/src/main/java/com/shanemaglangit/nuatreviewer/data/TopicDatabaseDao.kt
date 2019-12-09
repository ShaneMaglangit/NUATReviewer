package com.shanemaglangit.nuatreviewer.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TopicDatabaseDao {
    @Insert
    fun insert(topic: Topic): Long

    @Update
    fun update(topic: Topic)

    @Query("SELECT * FROM topic_table WHERE topicId = :topicId")
    fun getTopic(topicId: Long): Topic

    @Query("SELECT * FROM topic_table WHERE category = :category")
    fun getTopicByCategory(category: String): LiveData<List<Topic>>
}