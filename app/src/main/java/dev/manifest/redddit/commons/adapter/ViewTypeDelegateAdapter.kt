package dev.manifest.redddit.commons.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

// This interface allow us to have a generic list of delegate adapters and invoke those methods
// without requiring us to have in our NewsAdapter to know nothing specific of the delegated adapters implementation.
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}