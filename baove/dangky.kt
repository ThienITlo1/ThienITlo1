package com.example.kotlin.baove

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R

@Composable
fun dangky(navController: NavController) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var cpassword by remember { mutableStateOf("") }
    var firstNameError by remember { mutableStateOf(false) }
    var lastNameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    var cpasswordError by remember { mutableStateOf(false) }

    val context = LocalContext.current
    fun create(){
        if(email.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || cpassword.isEmpty()){
            emailError = email.isEmpty()
            passwordError = password.isEmpty()
            firstNameError = firstName.isEmpty()
            lastNameError = lastName.isEmpty()
            Toast.makeText(context, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
            return
        }
        if(password.length < 8){
            passwordError = password.length < 8
            Toast.makeText(context, "Mật khẩu phải có ít nhất 8 ký tự", Toast.LENGTH_SHORT).show()
            return
        }

        // Chuyển đổi email thành chữ in hoa
        val formattedEmail = email
        //Hiển thị thông báo đn thành công
        Toast.makeText(context, "Đăng nhập thành công $formattedEmail", Toast.LENGTH_SHORT).show()

        navController.navigate("homebv")
    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(color = Color(0xFF33907C)),

        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Text(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                text = "Welcome to tradly",
                fontWeight = FontWeight(500),
                fontSize = 24.sp,
                color = Color.White
            )
            Text(
                modifier = Modifier
                    .padding(top = 20.dp),
                text = "Signup to your account",
                fontSize = 16.sp,
                color = Color.White
            )
            TextField(
                value = firstName, // Giá trị hiện tại của TextField (ở đây là rỗng)
                onValueChange = { firstName = it}, // Hàm được gọi khi giá trị thay đổi (ở đây chưa làm gì)
                label = { Text("First Name") }, // Nhãn hiển thị bên trên TextField
                placeholder = { Text("Nhập tên đầy đủ của bạn") }, // Văn bản gợi ý khi TextField trống
//                leadingIcon = { Icon(Icons.Filled.Person, contentDescription = "Email") }, // Biểu tượng hiển thị ở đầu TextField
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    )
                    .height(48.dp), // Thêm padding dưới TextField
                colors = TextFieldDefaults.colors( // Tùy chỉnh màu sắc
//                    focusedContainerColor = Color.White, // Màu nền khi được focus
//                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                    focusedIndicatorColor = Color.Transparent,// Màu gạch chân khi được focus (trong suốt)
                    unfocusedIndicatorColor = Color.Transparent // Màu gạch chân khi không được focus (trong suốt)
                ),
                shape = RoundedCornerShape(24.dp), // Hình dạng góc bo tròn
                textStyle = TextStyle(fontSize = 16.sp) // Kiểu chữ của văn bản trong TextField
            )
            TextField(
                value = lastName,
                onValueChange = { lastName = it},
                label = { Text("Last Name") },
                placeholder = { Text("Nhập email của bạn") },
//                leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Name") },
                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White, // Màu nền khi được focus
//                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                    focusedIndicatorColor = Color.Transparent,// Màu gạch chân khi được focus (trong suốt)
                    unfocusedIndicatorColor = Color.Transparent // Màu gạch chân khi không được focus (trong suốt)
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email/Number Phone") },
                placeholder = { Text("Nhập mật khẩu của bạn") },
//                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password") },
                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White, // Màu nền khi được focus
//                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                    focusedIndicatorColor = Color.Transparent,// Màu gạch chân khi được focus (trong suốt)
                    unfocusedIndicatorColor = Color.Transparent // Màu gạch chân khi không được focus (trong suốt)
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Xác nhận lại mật khẩu") },
//                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password") },
                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White, // Màu nền khi được focus
//                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                    focusedIndicatorColor = Color.Transparent,// Màu gạch chân khi được focus (trong suốt)
                    unfocusedIndicatorColor = Color.Transparent // Màu gạch chân khi không được focus (trong suốt)
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            TextField(
                value = cpassword,
                onValueChange = { cpassword = it },
                label = { Text("Re-enter Password") },
                placeholder = { Text("Xác nhận lại mật khẩu") },
//                leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Confirm Password") },
                colors = TextFieldDefaults.colors(
//                    focusedContainerColor = Color.White, // Màu nền khi được focus
//                    unfocusedContainerColor = Color.White, // Màu nền khi không được focus
//                    focusedIndicatorColor = Color.Blue, // Màu đường gạch chân khi được focus
//                    unfocusedIndicatorColor = Color.Gray // Màu đường gạch chân khi không được focus
                    focusedIndicatorColor = Color.Transparent,// Màu gạch chân khi được focus (trong suốt)
                    unfocusedIndicatorColor = Color.Transparent // Màu gạch chân khi không được focus (trong suốt)
                ),
                modifier = Modifier.padding(top = 10.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(24.dp)
                    ),
                shape = RoundedCornerShape(24.dp),
                textStyle = TextStyle(fontSize = 16.sp)
            )
            Box(
                modifier = Modifier
                    .padding(top = 25.dp)
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable { create() }
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(Color(0xFFFFFFFF)),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Create",
                    color = Color(0xFF13B58C),
                    fontSize = 16.sp
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
                    color = Color.White
                )
                Text(
                    text = "Sign In",
                    fontWeight = FontWeight(700),
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}