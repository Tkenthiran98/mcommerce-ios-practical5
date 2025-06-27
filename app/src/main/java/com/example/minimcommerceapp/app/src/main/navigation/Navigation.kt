package com.example.minimcommerceapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.minimcommerceapp.ui.screens.CartScreen
import com.example.minimcommerceapp.ui.screens.ProductDetailScreen
import com.example.minimcommerceapp.ui.screens.ProductListScreen

@Composable
fun Navigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = "product_list",
        modifier = modifier
    ) {
        composable("product_list") {
            ProductListScreen(
                onProductClick = { productId ->
                    navController.navigate("product_detail/$productId")
                },
                onCartClick = {
                    navController.navigate("cart")
                }
            )
        }
        
        composable("product_detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: 0
            ProductDetailScreen(
                productId = productId,
                onBackClick = {
                    navController.popBackStack()
                },
                onCartClick = {
                    navController.navigate("cart")
                }
            )
        }
        
        composable("cart") {
            CartScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}