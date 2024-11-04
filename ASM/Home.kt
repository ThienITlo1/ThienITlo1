package com.example.kotlin.ASM

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import com.example.kotlin.viewmodel.ViewModelApp

@Composable
fun Home(navController: NavController, navBackStackEntry: NavBackStackEntry? = null, viewModel: ViewModelApp = viewModel()) {
    // Lấy id từ params truyền qua NavController
    val categoryId = navBackStackEntry?.arguments?.getString("id") ?: return

    // Lấy danh sách danh mục và danh sách sản phẩm từ ViewModel
    val listCate by viewModel.categorys
    val listProducts by viewModel.products

    LaunchedEffect(Unit) {
        // Gọi API để lấy danh mục khi màn hình được tải
        viewModel.getCategoryViewModel()
    }

    LaunchedEffect(categoryId) {
        // Gọi API để lấy sản phẩm theo danh mục khi categoryId thay đổi
        viewModel.getProductsByCategory(categoryId)
    }

    LazyColumn {
        // Hiển thị danh sách danh mục
        items(listCate) { category ->
            Card(
                modifier = Modifier
                    .clickable {
                        // Khi nhấn vào danh mục, điều hướng đến danh sách sản phẩm theo ID danh mục
                        navController.navigate("home/${category.idCate}")
                    }
            ) {
                Text(text = category.nameCate)
            }
        }

        // Hiển thị danh sách sản phẩm
        items(listProducts) { product ->
            Card {
                Text(text = product.nameProduct)
            }
        }
    }
}
