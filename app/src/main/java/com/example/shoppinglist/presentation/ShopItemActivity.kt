package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppinglist.databinding.ShopItemActivityBinding

class ShopItemActivity : AppCompatActivity() {

    private lateinit var binding: ShopItemActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ShopItemActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}