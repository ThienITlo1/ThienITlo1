package com.example.kotlin.Lab7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun otp(navController: NavController) {

    fun onClick() {
        navController.navigate("password")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(
            text = "Delivery of",
            fontSize = 49.sp,
            color = Color(0xFF8FD776),
            modifier = Modifier.padding(top = 100.dp).align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "products",
            fontSize = 49.sp,
            color = Color(0xFF8FD776),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Authorization or registration",
            fontSize = 20.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight(700)
        )
        Text(
            text = "We have sent a message to \nphone +7 999 123 45 67",
            fontSize = 16.sp,
            color = Color(0xFF6B6D7B),
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
        )
        Row (modifier = Modifier.padding(top = 20.dp).width(252.dp).align(Alignment.CenterHorizontally),horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.size(width = 51.dp, height = 51.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.size(width = 51.dp, height = 51.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.size(width = 51.dp, height = 51.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.size(width = 51.dp, height = 51.dp)
            )

        }

        Button(
            onClick = {onClick()},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF8FD776),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(top = 24.dp)
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(text = "Request code via 59")
        }
        Text(
            text = "By clicking on the \"Confirm Login\" button, I agree to the terms of use of the service",
            fontSize = 12.sp,
            color = Color(0xFF8F8F8F),
            modifier = Modifier
                .padding(top = 30.dp)
                .align(Alignment.CenterHorizontally)
        )
    }

}
