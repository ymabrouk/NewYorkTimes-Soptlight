/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mindset.SpotTimesApplication
import com.android.mindset.R
import com.android.mindset.databinding.FragmentNewsListBinding
import com.android.mindset.domain.model.News
import com.android.mindset.domain.model.NewsInfo
import com.android.mindset.presentation.adapter.NewsFeedAdapter
import com.android.mindset.presentation.vm.AppViewModelFactory
import com.android.mindset.presentation.vm.NewsListViewModel
import jp.wasabeef.recyclerview.animators.LandingAnimator
import javax.inject.Inject


class NewsListFragment : BaseFragment() {


    private var binding : FragmentNewsListBinding? = null

    @Inject
    lateinit var appViewModelFactory: AppViewModelFactory

    private var recyclerView : RecyclerView? = null;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentNewsListBinding.inflate(inflater, container, false)
        loaderView = binding?.loading;
        recyclerView = binding?.itemRv;
        val layoutManager =  LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView?.layoutManager =layoutManager
        val dividerItemDecoration = DividerItemDecoration(
            recyclerView?.context,
            layoutManager.orientation
        )
        recyclerView?.addItemDecoration(dividerItemDecoration)
        recyclerView?.itemAnimator = LandingAnimator()
        return binding?.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsListViewModel = ViewModelProviders.of(this,appViewModelFactory).get(NewsListViewModel::class.java)
        newsListViewModel.responseLiveData().observe(viewLifecycleOwner){
            showResult(it)
        }
        newsListViewModel.fetchNewsList()
    }


    override fun populateUi(result: Any) {
        when(result){
            is NewsInfo -> {
                binding?.itemRv?.adapter = NewsFeedAdapter(
                    result.results,
                    this
                );
                return
            }
            is String -> {
                showMessage(result as String)
                return
            }
            else -> {
                showMessage(getString(R.string.default_error_msg))
                return
            }
        }
    }

    override fun onClick(view: View?) {
        val news = view?.tag as News
        getNavController()
            ?.navigate(NewsListFragmentDirections.actionListToDetail(news))

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val newsListComponent = (requireContext().applicationContext as SpotTimesApplication).applicationComponent.newsListComponent().create()
        newsListComponent.inject(this)
    }

}