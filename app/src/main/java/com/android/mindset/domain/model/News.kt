/*
 * *
 *  * Created by yasser on 12/22/22, 9:55 PM
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 12/22/22, 8:45 PM
 *
 */

package com.android.mindset.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Parcelize
data class News (
        @SerializedName("id") val id : String,
        @SerializedName("url") val url : String,
        @SerializedName("title") val title : String,
        @SerializedName("abstract") val abstract : String,
        @SerializedName("byline") val byLine : String,
        @SerializedName("type") val type : String,
        @SerializedName("published_date") val publishedDate : String,
        @SerializedName("updated") val updated : String,
        @SerializedName("section") val section : String,
        @SerializedName("source") val source : String,
        @SerializedName("media") val mediaList : List<Media>?
): Parcelable