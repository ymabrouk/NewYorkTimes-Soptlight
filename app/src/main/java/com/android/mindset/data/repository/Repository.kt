/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.data.repository

import com.android.mindset.data.remote.ApiService
import com.android.mindset.domain.model.NewsInfo
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) : IRepository {

    override suspend fun getPopularNews(
                section: String,
                period: String,
                apiKey: String
    )
    : NewsInfo {
        return apiService.getPopularNews(section,period,apiKey)
    }
}