package com.example.kotlin.de02

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kotlin.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun dkDe02(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(10.dp),
            contentAlignment = Alignment.Center
        ){
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Image(
                painter = painterResource(id = R.drawable.logode2),
                contentDescription = null,
                modifier = Modifier
                    .size(72.dp)
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Let’s Get Started",
                fontWeight = FontWeight(700),
                fontSize = 16.sp,
                color = Color(0xFF223263)
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                text = "Create an new account",
                fontWeight = FontWeight(400),
                fontSize = 12.sp,
                color = Color(0xFF9098B1)
            )
            TextField(
                value = "", // Giá trị hiện tại của TextField (ở đây là rỗng)
                onValueChange = {}, // Hàm được gọi khi giá trị thay đổi (ở đây chưa làm gì)
                label = { Text("Full name") }, // Nhãn hiển thị bên trên TextField
                placeholder = { Text("Nhập tên đầy đủ của bạn") }, // Văn bản gợi ý khi TextField trống
                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Email") }, // Biểu tượng hiển thị ở đầu TextField
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth(), // Thêm padding dưới TextField
                colors = TextFieldDefaults.colors( // Tùy chỉnh màu sắc
                    focusedContainerColor = Color.White, // Màu nền khi được focus
                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                ),
                shape = RoundedCornerShape(8.dp), // Hình dạng góc bo tròn
                textStyle = TextStyle(fontSize = 16.sp) // Kiểu chữ của văn bản trong TextField
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Email") },
                placeholder = { Text("Nhập email của bạn") },
                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Name") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, // Màu nền khi được focus
                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Password") },
                placeholder = { Text("Nhập mật khẩu của bạn") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, // Màu nền khi được focus
                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("ConFirm Password") },
                placeholder = { Text("Xác nhận lại mật khẩu") },
                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White, // Màu nền khi được focus
                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth()
                    .height(57.dp)
                    .clickable {  }
                    .clip(shape = RoundedCornerShape(5.dp))
                    .background(Color(0xFF40BFFF)),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Sign Up",
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp
                )
            }
            Row (
                modifier = Modifier
                    .padding(top = 30.dp)
            ){
                Text(
                    text = "have an account?",
                    fontWeight = FontWeight(400),
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp,
                    color = Color(0xFF40BFFF)
                )
            }
        }
    }
}