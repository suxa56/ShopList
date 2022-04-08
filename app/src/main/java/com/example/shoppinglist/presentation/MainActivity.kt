package com.example.shoppinglist.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.shoppinglist.R
import com.example.shoppinglist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    ShopItemFragment.OnEditingFinishedListener
//    MainFragment.IsOnePanelMode
{

//    private lateinit var binding: ActivityMainBinding
//    private var shopItemContainer: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        val view = binding.root
//        setContentView(view)
//        shopItemContainer = binding.shopItemContainer
//        binding.buttonAddShopItem.setOnClickListener {
//            if (isOnePaneMode()) {
//                val intent = ShopItemActivity.newIntentAddItem(this)
//                startActivity(intent)
//            } else {
//                val fragment = ShopItemFragment.newInstanceAddItem()
//                launchFragment(fragment)
//            }
//        }
    }

//    override fun isOnePanel() {
//        TODO("Not yet implemented")
//    }
//
//    private fun launchFragment(fragment: Fragment) {
//        supportFragmentManager.popBackStack()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.shop_item_container, fragment)
//            .addToBackStack(null)
//            .commit()
//    }
//
//    private fun isOnePaneMode(): Boolean {
//        return shopItemContainer == null
//    }

    override fun onEditingFinished() {
        supportFragmentManager.popBackStack()
    }
}