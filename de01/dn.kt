package com.example.kotlin.de01

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun dn(navController: NavController) {
    // Khai báo biến trạng thái cho email và password
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

    val context = LocalContext.current

    fun login() {
        if(email.isEmpty() || password.isEmpty()){
            emailError = email.isEmpty()
            passwordError = password.isEmpty()
            Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }
        if(password.length < 8){
            passwordError = password.length < 8
            Toast.makeText(context, "Mật khẩu phải có ít nhất 8 ký tự", Toast.LENGTH_SHORT).show()
            return
        }

        // Chuyển đổi email thành chữ in hoa
        val formattedEmail = email.uppercase()

        navController.navigate("home")

        //Hiển thị thông báo đn thành công
        Toast.makeText(context, "Đăng nhập thành công $formattedEmail", Toast.LENGTH_SHORT).show()
    }

    Box(modifier = Modifier.padding(
        top = 30.dp,
        start = 20.dp,
        end = 20.dp)
        .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ){
        Column(modifier = Modifier) {
            Text(
                text = "Welcome back to ",
                modifier = Modifier,
                fontSize = 24.sp, // Đổi từ fontsize thành fontSize
                fontWeight = FontWeight.Bold // Đổi từ fontweight thành fontWeight
            )
            Text(
                text = "Mega Mall",
                modifier = Modifier,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Silahkan masukan data untuk login",
                modifier = Modifier.padding(top = 20.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Text(
                text = "Email/Phone",
                modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.padding(bottom = 30.dp).fillMaxWidth(),
            )
            Text(
                text = "Password",
                modifier = Modifier.padding(bottom = 10.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.padding(bottom = 30.dp).fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(100.dp)) // Thêm khoảng trống trước nút "Sign In"
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clickable { login() }
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
                ){
                Text(
                    text = "Sign In",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Forgot Password",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(text = "Sign Up",
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    fontSize = 14.sp
                )
            }

        }
    }

}
