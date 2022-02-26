package com.example.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class ShopItemViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    fun addShopItem(inputName: String?, inputCount: Int?) {
        val name = parseName(inputName)
        val count = parseCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            val shopItem = ShopItem(name, count, true)
            addShopItemUseCase.addShopItem(shopItem)
        }
    }

    fun getShopItem(shopItemId: Int) {
        getShopItemUseCase.getShopItem(shopItemId)
    }

    fun editShopItem(shopItem: ShopItem) {
        editShopItemUseCase.editShopItem(shopItem)
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    private fun parseCount(inputCount: Int?): Int {
        return if (inputCount == null || inputCount < 0) {
            0
        } else {
            inputCount
        }
    }

    private fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            // TODO: show error input name
            result = false
        }
        if (count <= 0) {
            // TODO: show error input count
            result = false
        }
        return result
    }
}