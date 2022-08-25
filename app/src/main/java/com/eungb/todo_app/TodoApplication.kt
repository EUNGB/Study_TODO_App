package com.eungb.todo_app

import android.app.Application
import com.eungb.todo_app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class TodoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Koin Trigger
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@TodoApplication)
            modules(appModule)
        }

    }

}