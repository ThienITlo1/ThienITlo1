package com.example.kotlin.services

import com.example.kotlin.models.Category
import com.example.kotlin.models.LoginReq
import com.example.kotlin.models.LoginRes
import com.example.kotlin.models.Product
import com.example.kotlin.models.RegisterReq
import com.example.kotlin.models.RegisterRes
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

// Interface định nghĩa API
interface ApiService {
    @GET("list-category.php")
    suspend fun getCategory(): List<Category>

    @POST("register.php")
    suspend fun register(@Body registerReq: RegisterReq): RegisterRes

    @POST("login.php")
    suspend fun login(@Body loginReq: LoginReq): LoginRes

    @GET("list-product-by-cate.php")
    suspend fun getProductsByCategory(@Query("id") categoryId: String): List<Product>

}

// Object để khởi tạo Retrofit
object RetrofitInstance {
    private const val BASE_URL = "https://vieclam.shop/"

    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}