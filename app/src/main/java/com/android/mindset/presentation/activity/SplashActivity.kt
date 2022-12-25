/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.android.mindset.R
import com.android.mindset.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNext();
        }, 3000)
    }

    private fun navigateToNext(){
        val intent  = Intent(this,SpotTimesActivity::class.java)
        startActivity(intent)
        finish()
    }
}