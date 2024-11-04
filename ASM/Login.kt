@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kotlin.ASM

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlin.R
import com.example.kotlin.models.LoginReq
import com.example.kotlin.viewmodel.ViewModelApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController, viewModel: ViewModelApp = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Snackbar state
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current

    // Truy cập trực tiếp vào giá trị của LoginRes từ ViewModel
    val loginState = viewModel.LoginRes.value

    // Hàm kiểm tra đăng nhập
    fun checkUser() {
        val user = LoginReq(email, password)
        viewModel.login(user) // Gửi yêu cầu đăng nhập
    }

    // Lắng nghe sự thay đổi của trạng thái đăng nhập
    LaunchedEffect(loginState) {
        loginState?.let { message ->
            if (message.status == true) {
                snackbarHostState.showSnackbar(message.message) // Hiển thị Snackbar
                navController.navigate("home")
            } else {
                snackbarHostState.showSnackbar("Có lỗi gì đó xảy ra") // Hiển thị Snackbar
            }
        }
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    // Giao diện người dùng
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.ccccc),
            contentDescription = "My Image",
            modifier = Modifier.width(screenWidth * 0.8f).height(200.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "Hello!", fontSize = 30.sp,
            color = Color(0xFF606060),
            modifier = Modifier.width(screenWidth * 0.8f)
        )
        Text(
            text = "WELCOME BACK", fontSize = 30.sp,
            color = Color(0xFF0C0A0A),
            modifier = Modifier.width(screenWidth * 0.8f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
            modifier = Modifier.width(screenWidth * 0.9f).drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            },
            label = { Text(text = "Email", fontSize = 20.sp) }
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                    contentDescription = "My Icon",
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
            modifier = Modifier.width(screenWidth * 0.9f).drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = size.height - strokeWidth / 2
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth
                )
            },
            label = { Text(text = "Password", fontSize = 20.sp) }
        )
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Forgot Password?", fontSize = 20.sp,
            color = Color(0xFF006400),
            textAlign = TextAlign.Center,
            modifier = Modifier.width(screenWidth * 0.8f)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { checkUser() },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(screenWidth * 0.9f)
                .height(60.dp)
                .background(
                    Color(0xFF242424),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
        ) {
            Text(text = "Log In", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate("register") },
            modifier = Modifier
                .padding(top = 16.dp)
                .width(screenWidth * 0.9f)
                .height(60.dp)
                .background(
                    Color(0xFFFFFF),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = "Sign Up", fontSize = 20.sp,
                color = Color(0xFF0C0A0A),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(screenWidth * 0.8f)
            )
        }
    }

    // Hiển thị Snackbar
    SnackbarHost(hostState = snackbarHostState) { snackbarData ->
        Snackbar(snackbarData)
    }
}
