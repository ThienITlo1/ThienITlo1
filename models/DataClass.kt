package com.example.kotlin.models

data class Category(val idCate: String, val nameCate: String)

data class RegisterReq(val email: String, val name: String, val password: String)
data class RegisterRes(val status: Boolean, val message: String)

data class LoginReq(val email: String, val password: String)
data class LoginRes(val status: Boolean, val message: String)
data class Product(
    val id: String,
    val nameProduct: String,
    val price: Double,
    val imageUrl: String // Nếu API có trả về URL hình ảnh
)

