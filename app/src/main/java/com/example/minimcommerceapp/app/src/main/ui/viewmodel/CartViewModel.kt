package com.example.minimcommerceapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.minimcommerceapp.data.model.CartItem
import com.example.minimcommerceapp.data.model.Product
import com.example.minimcommerceapp.data.repository.CartRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartViewModel(private val repository: CartRepository) : ViewModel() {
    
    private val _uiState = MutableStateFlow(CartUiState())
    val uiState: StateFlow<CartUiState> = _uiState.asStateFlow()
    
    init {
        viewModelScope.launch {
            repository.cartItems.collect { items ->
                _uiState.value = _uiState.value.copy(
                    cartItems = items,
                    totalPrice = repository.getTotalPrice()
                )
            }
        }
    }
    
    fun addToCart(product: Product) {
        repository.addToCart(product)
    }
    
    fun updateQuantity(productId: Int, quantity: Int) {
        repository.updateQuantity(productId, quantity)
    }
    
    fun removeFromCart(productId: Int) {
        repository.removeFromCart(productId)
    }
}

data class CartUiState(
    val cartItems: List<CartItem> = emptyList(),
    val totalPrice: Double = 0.0
)

class CartViewModelFactory(private val repository: CartRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CartViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}