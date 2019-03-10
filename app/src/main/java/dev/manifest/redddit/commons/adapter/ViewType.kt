package dev.manifest.redddit.commons.adapter

// Is an interface that we will use for the items that we are going to show in the RecyclerView.
// Each item must implement this interface so we can ask to each item the ViewType type (int value)
// and search for the corresponding delegated adapter to this type
interface ViewType {

    fun getViewType(): Int
}