package com.example.shoppinglist.presentation

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.shoppinglist.domain.ShopItem
import com.google.android.material.textfield.TextInputEditText

@BindingAdapter("etName")
fun bindingETName(textInputEditText: TextInputEditText, shopItem: LiveData<ShopItem>) {
    textInputEditText.setText(shopItem.value?.name ?: run { "" })
}

@BindingAdapter("etCount")
fun bindingETCount(textInputEditText: TextInputEditText, shopItem: LiveData<ShopItem>) {
    textInputEditText.setText(shopItem.value?.count?.toString() ?: run { "" })
}