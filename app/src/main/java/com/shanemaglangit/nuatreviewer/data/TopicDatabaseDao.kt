package com.shanemaglangit.nuatreviewer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface TopicDatabaseDao {
    @Insert
    fun insert(topic: Topic): Long

    @Insert
    fun insert(question: Question): Long

    @Transaction
    fun insertAllTopicWithQuestions(topicsWithQuestion: List<TopicWithQuestion>) {
        topicsWithQuestion.forEach {
            val topicId = insert(it.topic)

            it.questions.forEach {question ->
                question.questionTopicId = topicId
                insert(question)
            }
        }
    }

    @Query("SELECT * FROM topic_table WHERE topicId = :topicId")
    fun getTopic(topicId: Long) : Topic

    @Query("SELECT * FROM topic_table")
    fun getAllTopic(): List<Topic>

    @Query("SELECT * FROM topic_table WHERE subject = :subject")
    fun getAllTopicBySubject(subject: String): List<Topic>

    @Query("SELECT DISTINCT category FROM topic_table WHERE subject = :subject")
    fun getCategoryBySubject(subject: String): List<String>

    @Query("SELECT topicId, title FROM topic_table WHERE category = :category")
    fun getTopicIdAndTitleByCategory(category: String): List<Topic>

    @Query("SELECT * FROM question_table WHERE questionTopicId = :topicId")
    fun getQuestionsByTopicId(topicId: Long): MutableList<Question>
}