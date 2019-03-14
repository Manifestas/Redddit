package dev.manifest.redddit.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.manifest.redddit.R
import dev.manifest.redddit.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        TODO("not implemented")
    }


    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)
    )
}