package dev.manifest.redddit.news


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.manifest.redddit.R
import dev.manifest.redddit.commons.inflate

class NewsFragment : Fragment() {

    private var newsList: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = container?.inflate(R.layout.fragment_news)
        newsList = view?.findViewById<RecyclerView?>(R.id.news_list)
        newsList?.setHasFixedSize(true)
        newsList?.layoutManager = LinearLayoutManager(context)

        return view
    }


}
