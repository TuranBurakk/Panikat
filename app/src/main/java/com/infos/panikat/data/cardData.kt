package com.infos.panikat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class cardData(
    val title : String? = null,
    val desc : String? = null,
    val time : String? = null,
):Parcelable
