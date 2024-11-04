package com.example.myapplication2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import kotlin.random.nextInt

class giaodien2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            manghinh();
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  manghinh() {

    var so1 by remember { mutableStateOf("") }
    var so2 by remember { mutableStateOf("") }
    var ketqua by remember { mutableStateOf("") }
    var check by remember { mutableStateOf(false) }
    var randomNumber by remember { mutableStateOf(0) }
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }
    var pheptoan by remember { mutableStateOf(0) }
    var dau by remember { mutableStateOf("") }
    var ramdomO by remember { mutableStateOf(0) }
    var currentText by remember { mutableStateOf("1") }
    var numbers = remember { mutableStateListOf<String>() }
    var emptyIndex  by remember { mutableStateOf(0) }
    var emptyValue by remember { mutableStateOf("") }
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    fun baitoan(){

        emptyIndex = Random.nextInt(0..3);
        so1 = (1..10).random().toString()
        so2 = (1..10).random().toString()
        randomNumber = Random.nextInt(0..1)
        pheptoan = Random.nextInt(1..4)
        ramdomO = Random.nextInt(1..4)
        when(pheptoan){
            1 -> {
                ketqua = (so1.toInt() + so2.toInt()).toString()
                dau = "+"
            }
            2 -> {
                ketqua = (so1.toInt() - so2.toInt()).toString()
                dau = "-"
            }

            3 -> {
                ketqua = (so1.toInt() * so2.toInt()).toString()
                dau = "x"
            }

            4 -> {
                ketqua = (so1.toInt() / so2.toInt()).toString()
                dau = "/"
            }

        }
        numbers.clear();
        numbers.addAll(listOf(so1,dau,so2,ketqua))

    }
    LaunchedEffect(key1 = true) {
        baitoan();
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally){
                Text(
                    text = "Bạn Giỏi Phép Toán",
                    fontSize = 30.sp,
                    color = Color.Red,
                    textAlign = TextAlign.Center)
//                Box(
//                    modifier = Modifier
//                        .size(100.dp)
//                        .background(Color.Green),
//                    contentAlignment = Alignment.Center
//
//
//                ){
//                    OutlinedTextField(
//                        value = currentText,
//                        onValueChange = { newText ->
//                            currentText = newText
//                        },
//
//                        textStyle = TextStyle(fontSize = 60.sp, textAlign = TextAlign.Center),
//                                modifier = Modifier.size(100.dp)
//
//
//                    )
//                Spacer(modifier = Modifier.height(10.dp))
                Column() {
                    numbers.forEachIndexed{
                            index, text ->
                        if (index == emptyIndex){
                            emptyValue = ""
                        }
                        else{
                            emptyValue = text
                        }
                        OutlinedTextField(
                        value = emptyValue,
                        onValueChange = {if (index == emptyIndex) {
                            if (text == it){
                                dialogMessage="Bạn đã đúng";

                            }
                            else{
                                dialogMessage="Bạn đã sai";
                            }
                            showDialog=true;


                        }

                        },
//                            readOnly = true,

                        textStyle = TextStyle(fontSize = 60.sp, textAlign = TextAlign.Center),
                                modifier = Modifier.size(100.dp).border(1.dp, Color.Black),
                            readOnly = index != emptyIndex


                    )
                Spacer(modifier = Modifier.height(10.dp))
                        if (index ==2){
                            Text(
                                text = "=",
                                fontSize = 60.sp,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.size(100.dp).border(1.dp, Color.Black)
                            )
                Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
                Button  (onClick = { check=true }, modifier = Modifier
                    .padding(top = 16.dp)
                    .width(screenWidth * 0.9f)
                    .background(Color(0xFF006400)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent) // Đặt màu nền trong suốt
                ) {
                    Text(text = "ĐÚNG")
                }

//                }


            }
        }

    }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
                baitoan()
            },
            title = { Text("Kết quả") },
            text = { Text(dialogMessage) },
            confirmButton = {
                Button(onClick = {
                    showDialog = false
                    baitoan()
                }) {
                    Text("Tiếp tục")
                }
            }
        )
    }
}