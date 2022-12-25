/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.mindset.databinding.ItemNewsLayoutBinding
import com.android.mindset.domain.model.News
import com.android.mindset.utils.setImageUrl

class NewsFeedAdapter  (
    private val newsList: List<News>,
    private val listener: View.OnClickListener
) : RecyclerView.Adapter<NewsFeedAdapter.NewsVH>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemNewsLayoutBinding = ItemNewsLayoutBinding.inflate(layoutInflater, parent, false)
        binding.listener = listener
        return NewsVH(binding)
    }
    override fun onBindViewHolder(holder: NewsVH, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size


    class NewsVH(binding: ItemNewsLayoutBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {

        private val binding: ItemNewsLayoutBinding
        fun bind(news: News ){
            binding.news = news
            if((news.mediaList?.size ?: 0) > 0
                && (news.mediaList?.get(0)?.metaDataList?.size ?: 0) > 0
            ){
//              val imageUrl = news.mediaList?.get(0)?.metaDataList?.get(0)?.url
                val hdMedia = news.mediaList?.get(0)?.metaDataList?.firstOrNull { it.format == "Standard Thumbnail" }
                binding.userIV.setImageUrl(hdMedia?.url)
            }
            binding.executePendingBindings()
        }
        init {
            this.binding = binding
        }
    }

}