/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.activity

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    fun showMessage(message : String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}