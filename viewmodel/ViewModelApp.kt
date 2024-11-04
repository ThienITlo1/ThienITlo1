package com.example.kotlin.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import com.example.kotlin.models.Category
import com.example.kotlin.models.LoginReq
import com.example.kotlin.models.LoginRes
import com.example.kotlin.models.Product
import com.example.kotlin.models.RegisterReq
import com.example.kotlin.models.RegisterRes
import com.example.kotlin.services.RetrofitInstance

class ViewModelApp : ViewModel(){
    private val _categorys = mutableStateOf<List<Category>>(emptyList())
    val categorys: State<List<Category>> = _categorys

    private val _message = mutableStateOf<RegisterRes?>(null)
    val message: State<RegisterRes?> = _message

    private val _LoginRes = mutableStateOf<LoginRes?>(null)
    val LoginRes: State<LoginRes?> = _LoginRes

    fun getCategoryViewModel() {
        viewModelScope.launch {
            try {
                _categorys.value = RetrofitInstance.api.getCategory()
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    fun register(register: RegisterReq) {
        viewModelScope.launch {
            try {
                _message.value = RetrofitInstance.api.register(register)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    fun login(login: LoginReq) {
        viewModelScope.launch {
            try {
                _LoginRes.value = RetrofitInstance.api.login(login)
            } catch (e: Exception) {
                // Xử lý lỗi nếu cần
                Log.d("=======",e.toString())
            }
        }
    }

    // Lưu trữ danh sách sản phẩm để hiển thị trong UI
    private val _products = mutableStateOf<List<Product>>(emptyList())
    val products: State<List<Product>> = _products

    // Hàm lấy sản phẩm theo danh mục
    fun getProductsByCategory(categoryId: String) {
        viewModelScope.launch {
            // Gọi API để lấy sản phẩm theo ID danh mục
            val productList = RetrofitInstance.api.getProductsByCategory(categoryId)
            _products.value = productList
        }
    }

}