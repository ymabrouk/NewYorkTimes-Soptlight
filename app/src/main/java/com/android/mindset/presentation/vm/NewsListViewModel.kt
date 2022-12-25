/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.vm


import androidx.lifecycle.viewModelScope
import com.android.mindset.data.remote.ApiError
import com.android.mindset.domain.model.NewsInfo
import com.android.mindset.domain.model.NewsRequest
import com.android.mindset.domain.model.Response
import com.android.mindset.domain.usecase.NewsUseCase
import com.android.mindset.domain.usecase.base.UseCaseResponse
import javax.inject.Inject


class NewsListViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
): BaseVM() {

    private lateinit var mResult: NewsInfo


    fun fetchNewsList() {
        if(this::mResult.isInitialized){
            return
        }

        liveData.postValue(Response.Loading)
        newsUseCase.invoke(viewModelScope, NewsRequest(), object : UseCaseResponse<NewsInfo> {
            override fun onSuccess(result: NewsInfo) {
                mResult = result
                liveData.postValue(Response.Success(result))
            }

            override fun onError(apiError: ApiError?) {
                liveData.postValue(apiError?.getErrorMessage()?.let {
                    Response.Error(it)
                })
            }
        },)
    }
}