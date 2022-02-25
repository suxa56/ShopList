package com.example.shoppinglist.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.ShopItem

class ShopItemDiffUtil: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }

}