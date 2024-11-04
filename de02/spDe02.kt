package com.example.kotlin.de02

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlin.R
import com.example.kotlin.de01.Product
import com.example.kotlin.de01.ProductItem

data class Product(val imageRes: Int, val name: String, val price: String)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun spDe02(){

    val products = listOf(
        Product(R.drawable.jett, "Jett", "$10"),
        Product(R.drawable.neon, "Neon", "$15"),
        Product(R.drawable.iso, "Iso", "$20"),
        Product(R.drawable.reyna, "Reyna", "$25"),
        Product(R.drawable.yoru, "Yoru", "$30"),
        Product(R.drawable.phonix, "Phonix", "$35"),
        Product(R.drawable.clove, "Clove", "$40"),
        Product(R.drawable.omen, "Omen", "$45"),
        Product(R.drawable.viper, "Viper", "$50"),
        Product(R.drawable.fade, "Fade", "$55"),
        Product(R.drawable.sage, "Sage", "$60"),
        Product(R.drawable.chamber, "Chamber", "$65"),
    )

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(top = 30.dp, start = 20.dp, end = 20.dp)
    ){
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
        ){
            Row (modifier = Modifier
                    .fillMaxWidth()
                ){
                Box(
                    modifier = Modifier
                        .padding(bottom = 30.dp)
                ){
                    Image(
                        painter = painterResource(R.drawable.back),
                        contentDescription = "back",
                        modifier = Modifier.size(25.dp) // Kích thước biểu tượng
                    )
                }
                Text(
                    text = "Favorite Product",
                    fontWeight = FontWeight(700),
                    fontSize = 16.sp,
                    color = Color(0xFF223263),
                    modifier = Modifier.padding(start = 15.dp)
                )

            }
            // Danh sách sản phẩm
            LazyColumn {
                // Chia danh sách sản phẩm thành các hàng 2 sản phẩm
                items(products.chunked(2)) { rowProducts ->
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        // Hiển thị từng sản phẩm trong hàng
                        for (product in rowProducts) {
                            ProductItem(product) // Gọi hàm hiển thị sản phẩm
                        }
                    }
                }
            }
        }
    }
}

// Hàm để hiển thị thông tin của một sản phẩm
@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .padding(8.dp) // Khoảng cách giữa các sản phẩm
            .clip(RoundedCornerShape(8.dp)) // Bo góc cho sản phẩm
            .background(Color.White) // Màu nền cho sản phẩm
            .clickable { /* Handle product click */ } // Xử lý sự kiện click
            .size(width = 150.dp, height = 180.dp) // Kích thước sản phẩm
            .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp)),
        horizontalAlignment = Alignment.CenterHorizontally // Căn giữa nội dung
    ) {
        // Hiển thị hình ảnh sản phẩm
        Image(
            painter = painterResource(id = product.imageRes), // Hình ảnh sản phẩm
            contentDescription = product.name, // Mô tả hình ảnh
            modifier = Modifier
                .size(100.dp) // Kích thước hình ảnh
                .padding(top = 8.dp) // Khoảng cách bên trong hình ảnh
        )
        // Tên sản phẩm
        Text(
            text = product.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black // Màu chữ
        )
        // Giá sản phẩm
        Text(
            text = product.price,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray // Màu chữ
        )
        //icon xóa
        Icon(Icons.Filled.Delete, contentDescription = "delete")
    }
}