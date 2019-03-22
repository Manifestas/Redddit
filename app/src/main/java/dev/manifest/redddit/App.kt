package dev.manifest.redddit

import android.app.Application
import dev.manifest.redddit.di.AppModule
import dev.manifest.redddit.di.DaggerNewsComponent
import dev.manifest.redddit.di.NewsComponent

class App : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }
}