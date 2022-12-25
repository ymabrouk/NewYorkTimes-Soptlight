/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset

import android.app.Application
import com.android.mindset.di.component.ApplicationComponent
import com.android.mindset.di.component.DaggerApplicationComponent


class SpotTimesApplication : Application(){
    lateinit var applicationComponent : ApplicationComponent
    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create();
    }

}