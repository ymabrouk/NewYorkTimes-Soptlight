/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.di.component

import com.android.mindset.di.module.AppModule
import com.android.mindset.di.module.NetworkModule
import com.android.mindset.di.module.SubComponentsModule
import com.android.mindset.di.scope.ApplicationScope
import dagger.Component


@ApplicationScope
@Component(modules = [NetworkModule::class,AppModule::class,SubComponentsModule::class])
interface ApplicationComponent {
    fun newsListComponent() : NewsListComponent.Factory
}