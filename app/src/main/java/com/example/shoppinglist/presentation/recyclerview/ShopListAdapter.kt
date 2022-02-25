package com.example.shoppinglist.presentation.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {

    var shopList = emptyList<ShopItem>()

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardTitle = view.findViewById<TextView>(R.id.card_title)
        val cardCount = view.findViewById<TextView>(R.id.card_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.shop_item_enabled
            VIEW_TYPE_DISABLED -> R.layout.shop_item_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = shopList[position]
        holder.cardTitle.text = shopItem.name
        holder.cardCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener{
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        holder.itemView.setOnClickListener{
            onShopItemClickListener?.invoke(shopItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (shopList[position].enabled) {
            return VIEW_TYPE_ENABLED
        } else {
            return VIEW_TYPE_DISABLED
        }
    }

    override fun onViewRecycled(holder: ShopItemViewHolder) {
        super.onViewRecycled(holder)
        holder.cardTitle.text = ""
        holder.cardCount.text = ""

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

    companion object {
        const val VIEW_TYPE_DISABLED = 0
        const val VIEW_TYPE_ENABLED = 1

        const val MAX_POOL_SIZE = 30
    }
}