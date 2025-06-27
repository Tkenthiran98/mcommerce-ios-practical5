package com.example.minimcommerceapp.data.repository

import com.example.minimcommerceapp.data.model.CartItem
import com.example.minimcommerceapp.data.model.Product
import com.example.minimcommerceapp.utils.SharedPreferencesManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CartRepository(private val prefsManager: SharedPreferencesManager) {
    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: Flow<List<CartItem>> = _cartItems.asStateFlow()
    
    private val gson = Gson()
    
    init {
        loadCartFromPrefs()
    }
    
    fun addToCart(product: Product) {
        val currentItems = _cartItems.value.toMutableList()
        val existingItemIndex = currentItems.indexOfFirst { it.product.id == product.id }
        
        if (existingItemIndex != -1) {
            currentItems[existingItemIndex] = currentItems[existingItemIndex].copy(
                quantity = currentItems[existingItemIndex].quantity + 1
            )
        } else {
            currentItems.add(CartItem(product, 1))
        }
        
        _cartItems.value = currentItems
        saveCartToPrefs()
    }
    
    fun updateQuantity(productId: Int, quantity: Int) {
        val currentItems = _cartItems.value.toMutableList()
        val itemIndex = currentItems.indexOfFirst { it.product.id == productId }
        
        if (itemIndex != -1) {
            if (quantity > 0) {
                currentItems[itemIndex] = currentItems[itemIndex].copy(quantity = quantity)
            } else {
                currentItems.removeAt(itemIndex)
            }
            _cartItems.value = currentItems
            saveCartToPrefs()
        }
    }
    
    fun removeFromCart(productId: Int) {
        val currentItems = _cartItems.value.toMutableList()
        currentItems.removeAll { it.product.id == productId }
        _cartItems.value = currentItems
        saveCartToPrefs()
    }
    
    fun getTotalPrice(): Double {
        return _cartItems.value.sumOf { it.product.price * it.quantity }
    }
    
    private fun saveCartToPrefs() {
        val json = gson.toJson(_cartItems.value)
        prefsManager.saveCartItems(json)
    }
    
    private fun loadCartFromPrefs() {
        val json = prefsManager.getCartItems()
        if (json.isNotEmpty()) {
            val type = object : TypeToken<List<CartItem>>() {}.type
            val items = gson.fromJson<List<CartItem>>(json, type) ?: emptyList()
            _cartItems.value = items
        }
    }
}