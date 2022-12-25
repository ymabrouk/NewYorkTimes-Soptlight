/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.model

import com.google.gson.annotations.SerializedName


data class NewsInfo(
        @SerializedName("status") val status : String,
        @SerializedName("num_results") val numResult : Int,
        @SerializedName("results") val results : List<News>
)