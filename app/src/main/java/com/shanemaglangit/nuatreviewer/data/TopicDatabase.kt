package com.shanemaglangit.nuatreviewer.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import timber.log.Timber

@Database(entities = [Topic::class, Question::class], version = 1, exportSchema = false)
abstract class TopicDatabase : RoomDatabase() {
    abstract fun topicDao(): TopicDatabaseDao

    companion object {
        @Volatile
        private var INSTANCE: TopicDatabase? = null

        fun getInstance(context: Context): TopicDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    Timber.d("Creating instance")
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TopicDatabase::class.java,
                        "topic_database"
                    )
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                Timber.d("onCreate called!")

                                Thread(Runnable {
                                    getInstance(context).topicDao()
                                        .insertAllTopicWithQuestions(TopicData.populateData())
                                }).start()
                            }

                            override fun onOpen(db: SupportSQLiteDatabase) {
                                super.onOpen(db)
                                Timber.d("onOpen called!")

                                // TODO: Reminder to fix this.
                                /**
                                 * I have no idea of onCreate is actually working so I added this
                                 * in place to ensure that the data are being loaded.
                                 */
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