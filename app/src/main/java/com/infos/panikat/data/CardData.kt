package com.infos.panikat.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardData(
    val title : String? = null,
    val desc : String? = null,
    val time : String? = null,
    val exercise: String? = null,
):Parcelable
