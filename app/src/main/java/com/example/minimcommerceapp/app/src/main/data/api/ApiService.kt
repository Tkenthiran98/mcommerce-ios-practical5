package com.example.minimcommerceapp.data.api

import com.example.minimcommerceapp.data.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
    
    @GET("products/{id}")
    suspend fun getProduct(@Path("id") id: Int): Product
}