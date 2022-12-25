/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.usecase

import com.android.mindset.data.repository.IRepository
import com.android.mindset.domain.model.NewsInfo
import com.android.mindset.domain.model.NewsRequest
import com.android.mindset.domain.usecase.base.UseCase
import javax.inject.Inject


class NewsUseCase @Inject constructor(
    private val repository: IRepository
) : UseCase<NewsInfo, NewsRequest?>() {

    override suspend fun run(params: NewsRequest?): NewsInfo {
        // NewsRequest is nullable type, but this NewsRequest always would be non-null
        return repository.getPopularNews(params!!.section, params.period, params.apiKey)
    }

}