package com.example.shoppinglist.presentation.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R

class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val cardTitle: TextView = view.findViewById(R.id.card_title)
    val cardCount: TextView = view.findViewById(R.id.card_count)
}