package dev.manifest.redddit.news


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.manifest.redddit.R
import dev.manifest.redddit.commons.inflate
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment() {

    private val newsList by lazy { news_list }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsList.setHasFixedSize(true)
        newsList.layoutManager = LinearLayoutManager(context)
    }
}
