package com.example.minimcommerceapp.data.repository

import com.example.minimcommerceapp.data.api.RetrofitInstance
import com.example.minimcommerceapp.data.model.Product

class ProductRepository {
    private val api = RetrofitInstance.api
    
    suspend fun getProducts(): Result<List<Product>> {
        return try {
            val products = api.getProducts()
            Result.success(products)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    suspend fun getProduct(id: Int): Result<Product> {
        return try {
            val product = api.getProduct(id)
            Result.success(product)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}