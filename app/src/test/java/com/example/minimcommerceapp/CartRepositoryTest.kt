// package com.example.minimcommerceapp
//
// import com.example.minimcommerceapp.data.model.Product
// import com.example.minimcommerceapp.data.model.Rating
// import com.example.minimcommerceapp.data.repository.CartRepository
// import com.example.minimcommerceapp.utils.SharedPreferencesManager
// import kotlinx.coroutines.flow.first
// import kotlinx.coroutines.test.runTest
// import org.junit.Before
// import org.junit.Test
// import org.mockito.Mock
// import org.mockito.Mockito.*
// import org.mockito.MockitoAnnotations
//
// class CartRepositoryTest {
//
//     @Mock
//     private lateinit var prefsManager: SharedPreferencesManager
//
//     private lateinit var repository: CartRepository
//
//     @Before
//     fun setup() {
//         MockitoAnnotations.openMocks(this)
//         `when`(prefsManager.getCartItems()).thenReturn("")
//         repository = CartRepository(prefsManager)
//     }
//
//     @Test
//     fun `addToCart should add new product to cart`() = runTest {
//         val product = Product(1, "Test Product", 29.99, "Description", "Category", "image.jpg", Rating(4.5, 100))
//
//         repository.addToCart(product)
//
//         val cartItems = repository.cartItems.first()
//         assert(cartItems.size == 1)
//         assert(cartItems[0].product.id == product.id)
//         assert(cartItems[0].quantity == 1)
//     }
//
//     @Test
//     fun `addToCart should increase quantity for existing product`() = runTest {
//         val product = Product(1, "Test Product", 29.99, "Description", "Category", "image.jpg", Rating(4.5, 100))
//
//         repository.addToCart(product)
//         repository.addToCart(product)
//
//         val cartItems = repository.cartItems.first()
//         assert(cartItems.size == 1)
//         assert(cartItems[0].quantity == 2)
//     }
//
//     @Test
//     fun `removeFromCart should remove product from cart`() = runTest {
//         val product = Product(1, "Test Product", 29.99, "Description", "Category", "image.jpg", Rating(4.5, 100))
//
//         repository.addToCart(product)
//         repository.removeFromCart(product.id)
//
//         val cartItems = repository.cartItems.first()
//         assert(cartItems.isEmpty())
//     }
//
//     @Test
//     fun `getTotalPrice should calculate correct total`() = runTest {
//         val product1 = Product(1, "Product 1", 10.0, "Description", "Category", "image.jpg", Rating(4.5, 100))
//         val product2 = Product(2, "Product 2", 20.0, "Description", "Category", "image.jpg", Rating(4.0, 50))
//
//         repository.addToCart(product1)
//         repository.addToCart(product1)
//         repository.addToCart(product2)
//
//         val total = repository.getTotalPrice()
//         assert(total == 40.0)
//     }
// }