package dev.manifest.redddit.commons

import android.os.Parcel
import android.os.Parcelable
import dev.manifest.redddit.commons.adapter.AdapterConstants
import dev.manifest.redddit.commons.adapter.ViewType
import dev.manifest.redddit.commons.extensions.createParcel

data class RedditNews(
    val after: String,
    val before: String,
    val news: List<RedditNewsItem>
) : Parcelable {

    protected constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        mutableListOf<RedditNewsItem>().apply {
            parcel.readTypedList(this, RedditNewsItem.CREATOR)
        }
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(after)
        parcel.writeString(before)
        parcel.writeTypedList(news)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField
        @Suppress("unused")
        val CREATOR = createParcel { RedditNews(it) }
    }
}

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
) : ViewType, Parcelable {

    protected constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeString(title)
        parcel.writeInt(numComments)
        parcel.writeLong(created)
        parcel.writeString(thumbnail)
        parcel.writeString(url)
    }

    override fun describeContents() = 0

    companion object {
        @JvmField
        @Suppress("unused")
        val CREATOR = createParcel { RedditNewsItem(it) }
    }

    override fun getViewType() = AdapterConstants.NEWS
}