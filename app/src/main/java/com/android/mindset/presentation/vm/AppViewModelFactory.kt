/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.mindset.domain.usecase.NewsUseCase
import javax.inject.Inject

class AppViewModelFactory  @Inject constructor(private val newsUseCase: NewsUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            NewsListViewModel(newsUseCase) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}