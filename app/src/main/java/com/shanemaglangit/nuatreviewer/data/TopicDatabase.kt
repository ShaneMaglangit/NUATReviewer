package com.shanemaglangit.nuatreviewer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.shanemaglangit.nuatreviewer.util.Converter

@Database(entities = [Topic::class, Question::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class TopicDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDatabaseDao

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
                        "topic_database"
                    )
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)

                                Thread(Runnable {
                                    getInstance(context).topicDao()
                                        .insertAllTopicWithQuestions(TopicData.populateData())
                                }).start()
                            }
                        })
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}