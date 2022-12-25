/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.android.mindset.R
import com.android.mindset.databinding.ActivityTimesBinding


class SpotTimesActivity : BaseActivity() {
    lateinit var binding: ActivityTimesBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_times)

        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this,  navController);

    }

    fun getNavController(): NavController {
        return navController
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }


}