/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.mindset.databinding.FragmentNewsDetailBinding
import com.android.mindset.domain.model.News
import com.android.mindset.utils.setImageUrl


class NewsDetailFragment : BaseFragment() {
    private var binding : FragmentNewsDetailBinding? = null

    private lateinit var news : News;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentNewsDetailBinding.inflate(inflater,container,false)
        arguments?.let {
             news = NewsDetailFragmentArgs.fromBundle(it).news
        }

        return binding?.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.news  = news
        if(news.mediaList?.size?:0 > 0
            && news.mediaList?.get(0)?.metaDataList?.size?:0>0){
//            val imageUrl = news.mediaList?.get(0)?.metaDataList?.get(0)?.url
            val hdMedia = news.mediaList?.get(0)?.metaDataList?.firstOrNull { it.format == "mediumThreeByTwo440" }
            binding?.userIv?.setImageUrl(hdMedia?.url)
        }
    }

  /* override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true ,*//* enabled by default *//*) {
                override fun handleOnBackPressed() {
                    //getNavController()?.navigate(NewsDetailFragmentDirections.actionDetailToList())
                    getNavController()?.navigateUp()
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }*/

    override fun onClick(view: View?) {

    }
}