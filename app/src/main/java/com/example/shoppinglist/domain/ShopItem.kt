package com.example.shoppinglist.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShopItem(
    val name: String,
    val count: Int,
    val enabled: Boolean,
    var id: Int = UNDEFINED_ID
):Parcelable {
    companion object {
        const val UNDEFINED_ID = 0
    }
}
