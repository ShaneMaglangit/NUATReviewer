package com.shanemaglangit.nuatreviewer

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.shanemaglangit.nuatreviewer.data.TopicDatabaseDao
import com.shanemaglangit.nuatreviewer.di.appModule
import kotlinx.coroutines.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber
import timber.log.Timber.DebugTree

class MainActivity : AppCompatActivity() {
    private val database: TopicDatabaseDao by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar_action))

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }

        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }

        Timber.i(getDatabasePath("topic_database").absolutePath)

        performDummyQuery()

        NavigationUI.setupActionBarWithNavController(
            this,
            findNavController(R.id.nav_host_fragment)
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    /**
     * Needed to ensure that the database onCreate callback is being called
     */
    private fun performDummyQuery() {
        CoroutineScope(Dispatchers.Main + Job()).launch {
            withContext(Dispatchers.IO) {
                database.dummyQuery()
            }
        }
    }

    fun setSupportActionBarColor(color: Int) {
        supportActionBar?.apply {
            setBackgroundDrawable(ColorDrawable(color))
        }
    }
}
