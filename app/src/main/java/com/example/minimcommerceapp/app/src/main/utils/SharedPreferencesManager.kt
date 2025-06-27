package com.example.minimcommerceapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("cart_prefs", Context.MODE_PRIVATE)
    
    fun saveCartItems(json: String) {
        prefs.edit().putString("cart_items", json).apply()
    }
    
    fun getCartItems(): String {
        return prefs.getString("cart_items", "") ?: ""
    }
}