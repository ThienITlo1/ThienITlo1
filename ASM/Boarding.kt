package com.example.kotlin.ASM


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlin.R


@Composable
fun  Boarding(navController: NavController) {

    fun onClick() {
        navController.navigate("login")
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "My Image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds
    )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(250.dp))
            Text(
                text = "MAKE YOUR", fontSize = 30.sp,
                color = Color(0xFF606060),
                modifier = Modifier.width(screenWidth * 0.8f)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "HOME BEAUTIFUL", fontSize = 35.sp,

                modifier = Modifier.width(screenWidth * 0.8f)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "The best simple place where you discover most wonderful furnitures and make your home beautiful",
                fontSize = 20.sp,
                color = Color(0xFF808080),
                modifier = Modifier.width(screenWidth * 0.7f)
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button  (onClick = { onClick() }, modifier = Modifier
                .padding(top = 16.dp)
                .width(200.dp)
                .height(60.dp)
                .background(Color(0xFF242424),shape = RoundedCornerShape(8.dp)),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
            ) {
                Text(text = "Get Started",
                    fontSize = 20.sp,
                )
            }

        }

}
