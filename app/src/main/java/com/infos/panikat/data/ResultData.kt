package com.infos.panikat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResultData(
    val list:List<cardData>? = null
):Parcelable