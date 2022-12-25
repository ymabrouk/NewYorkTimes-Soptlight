/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.di.component

import com.android.mindset.di.scope.ActivityScope
import com.android.mindset.presentation.activity.SpotTimesActivity
import com.android.mindset.presentation.fragment.NewsDetailFragment
import com.android.mindset.presentation.fragment.NewsListFragment
import dagger.Subcomponent


@ActivityScope
@Subcomponent
interface NewsListComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create() : NewsListComponent
    }

    fun inject(nYTimesActivity: SpotTimesActivity)
    fun inject(newsListFragment: NewsListFragment)
    fun inject(newsDetailFragment: NewsDetailFragment)
}