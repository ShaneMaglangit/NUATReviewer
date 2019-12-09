package com.shanemaglangit.nuatreviewer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Topic::class], version = 1, exportSchema = false)
abstract class TopicDatabase : RoomDatabase() {
    abstract val topicDatabaseDao : TopicDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: TopicDatabase? = null

        fun getInstance(context: Context): TopicDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TopicDatabase::class.java,
                        "topic_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}