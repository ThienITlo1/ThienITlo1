package com.example.kotlin.ASM


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.kotlin.models.RegisterReq
import com.example.kotlin.viewmodel.ViewModelApp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun  SignUp(navController: NavController, viewModel: ViewModelApp = viewModel()) {

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val context = LocalContext.current
    fun checkUser() {
        val message by viewModel.message
        val user = RegisterReq(email, name, password)
        viewModel.register(user)
        if (message?.status == true){
            Toast.makeText(context, message?.message, Toast.LENGTH_SHORT).show()
            navController.navigate("login")
        } else {
            Toast.makeText(context, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show()
        }
    }
    fun onClick() {
        navController.popBackStack()
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFFFFFFFF)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.ccccc),
            contentDescription = "My Image",
            modifier = Modifier.width(screenWidth* 0.8f)
                .height(200.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = "WELCOME BACK ", fontSize = 30.sp,
            color = Color(0xFF0C0A0A),
            modifier = Modifier.width(screenWidth * 0.8f)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
            modifier = Modifier.width(screenWidth * 0.9f)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Độ dày của viền
                    val y = size.height - strokeWidth / 2 // Vị trí y của viền bottom
                    drawLine(
                        color = Color.Black, // Màu của viền
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth)
                }
            ,
            label = {
                Text(text = "Name", fontSize = 20.sp)
            }
        )
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                disabledBorderColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
            modifier = Modifier.width(screenWidth * 0.9f)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Độ dày của viền
                    val y = size.height - strokeWidth / 2 // Vị trí y của viền bottom
                    drawLine(
                        color = Color.Black, // Màu của viền
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth)
                }
            ,
            label = {
                Text(text = "Email", fontSize = 20.sp)
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
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
            modifier = Modifier.width(screenWidth * 0.9f)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Độ dày của viền
                    val y = size.height - strokeWidth / 2 // Vị trí y của viền bottom
                    drawLine(
                        color = Color.Black, // Màu của viền
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth)
                }
            ,
            label = {
                Text(text = "Password", fontSize = 20.sp)
            }
        )
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
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
            modifier = Modifier.width(screenWidth * 0.9f)
                .drawBehind {
                    val strokeWidth = 1.dp.toPx() // Độ dày của viền
                    val y = size.height - strokeWidth / 2 // Vị trí y của viền bottom
                    drawLine(
                        color = Color.Black, // Màu của viền
                        start = Offset(0f, y),
                        end = Offset(size.width, y),
                        strokeWidth = strokeWidth)
                }
            ,
            label = {
                Text(text = "Confirm Password", fontSize = 20.sp)
            }
        )

        Spacer(modifier = Modifier.height(50.dp))
        Button  (onClick = { checkUser() }, modifier = Modifier
            .padding(top = 16.dp)
            .width(screenWidth*0.9f)
            .height(60.dp)
            .background(Color(0xFF242424),shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(30.dp)),
            shape = RoundedCornerShape(30.dp)

            ,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
        ) {
            Text(text = "Sign Up",
                fontSize = 20.sp,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row (

        ){
            Text(
                text = "Already have an account?", fontSize = 17.sp,
                color = Color(0xFF303030),
                textAlign = TextAlign.Center,

            )
            Text(
                text = "SIGN IN", fontSize = 17.sp,
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
            )

        }


    }

}
@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label:String
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.baseline_remove_red_eye_24),
                contentDescription = "Show password"
            )
        },
        textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
        modifier = modifier.width(screenWidth * 0.9f),
        label = {
            Text(text = label, fontSize = 20.sp)
        }
    )
}