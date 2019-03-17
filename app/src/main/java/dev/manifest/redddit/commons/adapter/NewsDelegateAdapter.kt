package dev.manifest.redddit.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.manifest.redddit.R
import dev.manifest.redddit.commons.RedditNewsItem
import dev.manifest.redddit.commons.extensions.getFriendlyTime
import dev.manifest.redddit.commons.extensions.inflate
import dev.manifest.redddit.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item)
    ) {

        fun bind(item: RedditNewsItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}