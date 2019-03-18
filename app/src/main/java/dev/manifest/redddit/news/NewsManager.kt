package dev.manifest.redddit.news

import dev.manifest.redddit.api.NewsAPI
import dev.manifest.redddit.api.NewsRestAPI
import dev.manifest.redddit.commons.RedditNews
import dev.manifest.redddit.commons.RedditNewsItem
import rx.Observable

class NewsManager(private val api: NewsAPI = NewsRestAPI()) {

    /**
     * Returns Reddit News paginated by the given limit.
     *
     * @param after indicates the next page to navigate.
     * @param limit the number of news to request.
     */
    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create { subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(
                        item.author, item.title, item.num_comments,
                        item.created, item.thumbnail, item.url
                    )
                }
                val redditNews = RedditNews(
                    dataResponse.after ?: "",
                    dataResponse.before ?: "",
                    news
                )

                subscriber.onNext(redditNews)
                subscriber.onCompleted()

            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}

