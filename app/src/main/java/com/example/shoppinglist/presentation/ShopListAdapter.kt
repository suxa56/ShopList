package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter: RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = emptyList<ShopItem>()

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardTitle = view.findViewById<TextView>(R.id.card_title)
        val cardCount = view.findViewById<TextView>(R.id.card_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item_enabled, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.cardTitle.text = shopItem.name
        holder.cardCount.text = shopItem.count.toString()
//        holder.itemView.setOnLongClickListener{
//            true
//        }
    }

    fun setData(newShopList: List<ShopItem>) {
        val shopListDiffUtil = ShopListDiffUtil(shopList, newShopList)
        val shopListResult = DiffUtil.calculateDiff(shopListDiffUtil)
        this.shopList = newShopList
        shopListResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}