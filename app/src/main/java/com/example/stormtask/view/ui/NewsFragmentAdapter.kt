package com.example.stormtask.view.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.stormtask.view.entities.NewsEntity

class NewsFragmentAdapter(
    fragmentActivity: FragmentActivity,
    private val movies: List<NewsEntity>
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun createFragment(position: Int): Fragment {
        return NewsFragment.newInstance(movies[position])
    }
}