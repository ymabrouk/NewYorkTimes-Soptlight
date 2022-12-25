/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.vm

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.android.mindset.TestCoroutineRule
import com.android.mindset.data.repository.FakeRepository
import com.android.mindset.domain.model.NewsInfo
import com.android.mindset.domain.model.Response
import com.android.mindset.domain.usecase.NewsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsListViewModelTest{



    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    private lateinit var newsListViewModel: NewsListViewModel
    private lateinit var apiObserver: Observer<Response<Any>>
    private lateinit var newsSizeObserver: Observer<Response<Any>>


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        newsListViewModel = NewsListViewModel(NewsUseCase(FakeRepository()))

    }

    @Test
    fun `check Api status OK`(){
        testCoroutineRule.runBlockingTest {

            apiObserver = Observer {
                when(it) {
                    is Response.Success -> {
                        val newsInfo = (it.data as NewsInfo)
                        assertTrue("API STATUS is Fine","OK".equals(newsInfo.status,true))
                    }
                }

            }

            newsListViewModel.liveData.observeForever(apiObserver)
            newsListViewModel.fetchNewsList()
            newsListViewModel.liveData.removeObserver(apiObserver)
        }
    }

    @Test
    fun `check news available in response`(){
        testCoroutineRule.runBlockingTest {

            newsSizeObserver  = Observer {
                when(it) {
                    is Response.Success -> {
                        val newsInfo = (it.data as NewsInfo)
                        assertTrue("API having news list", newsInfo.results.isNotEmpty())
                    }
                }

            }

            newsListViewModel.liveData.observeForever(newsSizeObserver)
            newsListViewModel.fetchNewsList()
            newsListViewModel.liveData.removeObserver(newsSizeObserver)
        }
    }
}