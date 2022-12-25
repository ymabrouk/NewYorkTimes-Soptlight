/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.usecase.base

import com.android.mindset.data.remote.ApiError


interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(apiError: ApiError?)
}