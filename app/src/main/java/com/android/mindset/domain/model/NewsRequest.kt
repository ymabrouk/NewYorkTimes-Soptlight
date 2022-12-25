/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.model


data class NewsRequest(
    //hardcode value here for testing & for using default constructor
    val section:String="all-sections",
    val period : String="7",
    val apiKey : String="wfWJEVggepo0ouS9S5np0JSjOjWTuMaQ"
)