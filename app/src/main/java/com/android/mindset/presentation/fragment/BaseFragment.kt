/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.presentation.fragment

import android.content.Context
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.android.mindset.domain.model.Response
import com.android.mindset.presentation.activity.BaseActivity
import com.android.mindset.presentation.activity.SpotTimesActivity


abstract class BaseFragment : Fragment(),View.OnClickListener {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }


    var loaderView : View? = null;

    fun showResult(result: Response<Any>) {
        when(result) {
            is Response.Success -> {
                loader(false)
                populateUi(result.data)
            }
            is Response.Error -> {
                showMessage(result.error)
                loader(false)
            }
            is Response.Loading -> {
                loader(true)
            }
        }
    }

    open fun populateUi(result: Any){

    }


    fun loader(show: Boolean){
        if(show)
            loaderView?.visibility = View.VISIBLE
        else
            loaderView?.visibility = View.GONE
    }



    fun showMessage(message: String){
        (activity as BaseActivity).showMessage(message)
    }


   fun getNavController() : NavController?{
        return (activity as SpotTimesActivity).getNavController()
   }

}