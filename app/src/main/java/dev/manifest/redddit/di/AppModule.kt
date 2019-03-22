package dev.manifest.redddit.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dev.manifest.redddit.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun provideApplication(): App {
        return app
    }
}