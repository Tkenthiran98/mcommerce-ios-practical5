// package com.example.minimcommerceapp
//
// import com.example.minimcommerceapp.data.model.Product
// import com.example.minimcommerceapp.data.model.Rating
// import com.example.minimcommerceapp.data.repository.ProductRepository
// import com.example.minimcommerceapp.ui.viewmodel.ProductViewModel
// import kotlinx.coroutines.Dispatchers
// import kotlinx.coroutines.ExperimentalCoroutinesApi
// import kotlinx.coroutines.test.UnconfinedTestDispatcher
// import kotlinx.coroutines.test.resetMain
// import kotlinx.coroutines.test.runTest
// import kotlinx.coroutines.test.setMain
// import org.junit.After
// import org.junit.Before
// import org.junit.Test
// import org.mockito.Mock
// import org.mockito.Mockito.*
// import org.mockito.MockitoAnnotations
//
// @ExperimentalCoroutinesApi
// class ProductViewModelTest {
//
//     @Mock
//     private lateinit var repository: ProductRepository
//
//     private lateinit var viewModel: ProductViewModel
//     private val testDispatcher = UnconfinedTestDispatcher()
//
//     @Before
//     fun setup() {
//         MockitoAnnotations.openMocks(this)
//         Dispatchers.setMain(testDispatcher)
//         viewModel = ProductViewModel(repository)
//     }
//
//     @After
//     fun tearDown() {
//         Dispatchers.resetMain()
//     }
//
//     @Test
//     fun `loadProducts should update state with products on success`() = runTest {
//         val mockProducts = listOf(
//             Product(1, "Test Product", 29.99, "Description", "Category", "image.jpg", Rating(4.5, 100))
//         )
//         `when`(repository.getProducts()).thenReturn(Result.success(mockProducts))
//
//         viewModel.loadProducts()
//
//         assert(viewModel.uiState.value.products == mockProducts)
//         assert(!viewModel.uiState.value.isLoading)
//         assert(viewModel.uiState.value.error == null)
//     }
//
//     @Test
//     fun `loadProducts should update state with error on failure`() = runTest {
//         val errorMessage = "Network error"
//         `when`(repository.getProducts()).thenReturn(Result.failure(Exception(errorMessage)))
//
//         viewModel.loadProducts()
//
//         assert(viewModel.uiState.value.products.isEmpty())
//         assert(!viewModel.uiState.value.isLoading)
//         assert(viewModel.uiState.value.error == errorMessage)
//     }
// }