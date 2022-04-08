package com.example.shoppinglist.presentation

import android.provider.Settings.Global.getString
import androidx.core.widget.doOnTextChanged
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("etName")
fun bindingETName(
    textInputEditText: TextInputEditText,
    shopItem: LiveData<ShopItem>
) {
    textInputEditText.setText(shopItem.value?.name ?: run { "" })
}

@BindingAdapter("etCount")
fun bindingETCount(
    textInputEditText: TextInputEditText,
    shopItem: LiveData<ShopItem>
) {
    textInputEditText.setText(shopItem.value?.count?.toString() ?: run { "" })
}

@BindingAdapter("onCountChanged")
fun bindingOnCountChanged(
    textInputEditText: TextInputEditText,
    viewModel: ShopItemViewModel
) {
    textInputEditText.doOnTextChanged { _, _, _, _ -> viewModel.resetErrorInputCount() }
}

@BindingAdapter("onNameChanged")
fun bindingOnNameChanged(
    textInputEditText: TextInputEditText,
    viewModel: ShopItemViewModel
) {
    textInputEditText.doOnTextChanged { _, _, _, _ -> viewModel.resetErrorInputName() }
}

//@BindingAdapter("errorInputCount")
//fun bindingErrorInputCount(
//    textInputLayout: TextInputLayout,
//    errorInputCount: LiveData<Boolean>
//) {
//    errorInputCount.value?.let {
//        val message = if (it) {
//            textInputLayout.context.getString(R.string.error_input_count)
//        } else {
//            null
//        }
//        textInputLayout.error = message
//        textInputLayout.isErrorEnabled = it
//        textInputLayout.errorContentDescription = message
//    }
//}