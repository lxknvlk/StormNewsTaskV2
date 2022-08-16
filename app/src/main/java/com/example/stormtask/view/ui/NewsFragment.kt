package com.example.stormtask.view.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.stormtask.R
import com.example.stormtask.view.entities.NewsEntity
import com.example.stormtask.view.utils.NewsHelper
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class NewsFragment : Fragment() {

    companion object {
        fun newInstance(newsObject: NewsEntity): NewsFragment {
            val args = Bundle()
            args.putString(NewsHelper.KEY_TITLE, newsObject.title)
            args.putString(NewsHelper.KEY_DESCRIPTION, newsObject.description)
            args.putString(NewsHelper.KEY_IMAGE_URL, newsObject.urlToImage)
            args.putString(NewsHelper.KEY_CONTENT, newsObject.content)
            args.putString(NewsHelper.KEY_AUTHOR, newsObject.author)
            args.putString(NewsHelper.KEY_PUBLISH_DATE, newsObject.publishedAt.toString())
            args.putString(NewsHelper.KEY_URL, newsObject.url)

            val fragment = NewsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var tvTitle: TextView
    private lateinit var btnMore: Button
    private lateinit var tvDescription: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvPublishDate: TextView
    private lateinit var ivImage: ImageView
    private lateinit var pbLoader: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        tvTitle = view.findViewById(R.id.tvTitle)
        btnMore = view.findViewById(R.id.btnMore)
        tvDescription = view.findViewById(R.id.tvDescription)
        tvAuthor = view.findViewById(R.id.tvAuthor)
        tvPublishDate = view.findViewById(R.id.tvPublishDate)
        ivImage = view.findViewById(R.id.ivImage)
        pbLoader = view.findViewById(R.id.pbLoader)

        val newsTitle = arguments?.getString(NewsHelper.KEY_TITLE)
        val newsDescription = arguments?.getString(NewsHelper.KEY_DESCRIPTION)
        val newsImageUrl = arguments?.getString(NewsHelper.KEY_IMAGE_URL)
        val newsAuthor = arguments?.getString(NewsHelper.KEY_AUTHOR)
        val newsPublishDate = arguments?.getString(NewsHelper.KEY_PUBLISH_DATE)
        val newsUrl = arguments?.getString(NewsHelper.KEY_URL)

        tvTitle.text = newsTitle
        newsDescription?.let {
            tvDescription.text = it.replace("&nbsp;", "")
        }
        tvAuthor.text = newsAuthor
        tvPublishDate.text = newsPublishDate

        Picasso.get().load(newsImageUrl).into(ivImage, object : Callback {
            override fun onSuccess() {
                pbLoader.visibility = View.GONE
            }

            override fun onError(e: Exception?) {}
        })

        btnMore.setOnClickListener {
            val intent = Intent(activity, NewsWebViewActivity::class.java)
            intent.putExtra(NewsHelper.KEY_URL, newsUrl)
            startActivity(intent)
        }

        return view
    }
}