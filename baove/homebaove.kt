package com.example.kotlin.baove

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R

data class Product(val imageRes: Int, val name: String, val price: String)

@Composable
fun homebaove(navController: NavController) { // Đổi tên hàm từ home thành Home

    fun goBack(){
        navController.popBackStack()
    }

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

    // Thanh tiêu đề với các biểu tượng và tiêu đề
    Row(modifier = Modifier.fillMaxWidth().height(75.dp).background(color = Color(0xFF33907C)).padding(10.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        // Biểu tượng quay lại
        Box(
            modifier = Modifier
                .clickable { goBack() }
        ){
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier.size(30.dp) // Kích thước biểu tượng
            )
        }
        // Tiêu đề "Category"
        Text(
            text = "Beverages",
            fontSize = 20.sp, // Kích thước chữ
            fontWeight = FontWeight.Bold, // Độ đậm của chữ
            color = Color.White
        )
        // Biểu tượng thông báo
        Image(
            painter = painterResource(id = R.drawable.shop),
            contentDescription = null,
            modifier = Modifier.size(30.dp) // Kích thước biểu tượng
         )
    }
    Box(
        modifier = Modifier.padding(
            top = 30.dp, // Khoảng cách từ trên xuống
            start = 20.dp, // Khoảng cách từ bên trái
            end = 20.dp // Khoảng cách từ bên phải
        ).fillMaxHeight().fillMaxWidth() // Chiếm toàn bộ chiều cao và chiều rộng
    ) {
        Column(modifier = Modifier) {

            // Tiêu đề "Gadget"
            Text(
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp),
                text = "Gadget",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            // Ô tìm kiếm sản phẩm
            Box(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { /* Handle click */ } // Xử lý sự kiện click
                    .clip(shape = RoundedCornerShape(10.dp)) // Bo góc
                    .background(Color.LightGray), // Màu nền
                contentAlignment = Alignment.Center // Căn giữa nội dung
            ) {
                // Nội dung bên trong ô tìm kiếm
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Văn bản tìm kiếm
                    Text(
                        text = "Search Product Name",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray
                    )
                    // Biểu tượng tìm kiếm
                    Image(
                        painter = painterResource(R.drawable.search),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
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
    }
}