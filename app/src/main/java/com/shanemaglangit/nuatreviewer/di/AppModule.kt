package com.shanemaglangit.nuatreviewer.di

import com.shanemaglangit.nuatreviewer.data.TopicDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { TopicDatabase.getInstance(androidContext()).topicDao() }
}