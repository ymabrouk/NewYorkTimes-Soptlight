/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.vm

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mindset.domain.model.Response
import kotlinx.coroutines.cancel


open class BaseVM : ViewModel() , LifecycleObserver {

    val liveData = MutableLiveData<Response<Any>>()

    fun responseLiveData() : MutableLiveData<Response<Any>> {
        return liveData
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}