package dev.manifest.redddit.news


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dev.manifest.redddit.R
import dev.manifest.redddit.commons.adapter.NewsAdapter
import dev.manifest.redddit.commons.extensions.inflate
import kotlinx.android.synthetic.main.fragment_news.*
import rx.schedulers.Schedulers

class NewsFragment : Fragment() {

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_news)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)

        initAdapter()

        if (savedInstanceState == null) {
            requestNews()
        }
    }

    private fun requestNews() {
        val subscription = newsManager.getNews()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { retrievedNews -> (news_list.adapter as NewsAdapter).addNews(retrievedNews) },
                { e -> Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show() }
            )
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}
