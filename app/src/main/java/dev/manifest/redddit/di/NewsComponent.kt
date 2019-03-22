package dev.manifest.redddit.di

import dagger.Component
import dev.manifest.redddit.news.NewsFragment
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class, NewsModule::class, NetworkModule::class]
)
interface NewsComponent {

    fun inject(fragment: NewsFragment)
}