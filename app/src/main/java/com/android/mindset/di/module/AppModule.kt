/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.di.module

import com.android.mindset.di.qualifier.BaseUrlString
import com.android.mindset.di.qualifier.KeyString
import com.android.mindset.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides


@Module
class AppModule {

    @Provides
    @BaseUrlString
    @ApplicationScope
    fun provideBaseUrl() :String{
        return "https://api.nytimes.com/svc/mostpopular/v2/"
    }

    @Provides
    @KeyString
    @ApplicationScope
    fun provideApiKey() :String{
        return "QG7V7GJlPb4HVhSVoQodw3mlC2kGPtPZ"
    }
}