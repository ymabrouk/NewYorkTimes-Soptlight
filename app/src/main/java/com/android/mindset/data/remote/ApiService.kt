/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.data.remote

import com.android.mindset.domain.model.NewsInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
interface ApiService {

    @GET("mostviewed/{section}/{period}.json")
    suspend fun getPopularNews(
        @Path("section") section : String,
        @Path("period") period : String,
        @Query("api-key") apiKey : String
    ): NewsInfo
}