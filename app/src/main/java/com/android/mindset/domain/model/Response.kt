/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.model


sealed class Response<out T : Any> {
    data class Success<out T : Any>(val data: T) : Response<T>()
    data class Error(val error: String) : Response<Nothing>()
    object Loading : Response<Nothing>()
}