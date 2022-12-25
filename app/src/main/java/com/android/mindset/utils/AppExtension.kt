/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.utils
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

import android.view.View
import android.widget.ImageView
import com.android.mindset.R
import com.bumptech.glide.Glide

fun ImageView.setImageUrl(url: String?){

    val circularProgressDrawable = CircularProgressDrawable(context)
    circularProgressDrawable.strokeWidth = 5f
    circularProgressDrawable.centerRadius = 30f
    circularProgressDrawable.arrowEnabled = true
    circularProgressDrawable.setColorSchemeColors(R.color.primary)
    circularProgressDrawable.start()

    Glide.with(context)
        .load(url)
        .placeholder(circularProgressDrawable)
        .error(R.mipmap.ic_launcher)
        .into(this);

}

fun View.show(){
    visibility = View.VISIBLE
}

fun View.hide(){
    visibility = View.GONE
}