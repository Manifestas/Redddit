package dev.manifest.redddit.commons

import dev.manifest.redddit.commons.adapter.AdapterConstants
import dev.manifest.redddit.commons.adapter.ViewType

data class RedditNews(
    val after: String,
    val before: String,
    val news: List<RedditNewsItem>)

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}