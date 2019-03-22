package dev.manifest.redddit.di

import dagger.Module
import dagger.Provides
import dev.manifest.redddit.api.NewsAPI
import dev.manifest.redddit.api.NewsRestAPI
import dev.manifest.redddit.api.RedditApi
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NewsModule {

    @Singleton
    @Provides
    fun provideRedditApi(retrofit: Retrofit): RedditApi {
        return retrofit.create(RedditApi::class.java)
    }

    @Singleton
    @Provides
    fun provideNewsAPI(redditApi: RedditApi): NewsAPI {
        return NewsRestAPI(redditApi)
    }

}