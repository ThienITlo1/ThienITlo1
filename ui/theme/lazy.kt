package com.example.kotlin.ui.theme

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class Lazy : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeApp()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyComposeApp(){
    // Data class NhanVien
    data class NhanVien(val ma: Int, val ten: String, val luong: Int)

    // Danh sách nhân viên
    val list = remember {
        mutableStateListOf(
            NhanVien(1, "Văn A", 9),
            NhanVien(2, "Văn B", 8),
            NhanVien(3, "Văn C", 5),
            NhanVien(4, "Văn D", 6),
            NhanVien(5, "Văn E", 10),
        )
    }
    val context = LocalContext.current

    // Hiển thị danh sách bằng LazyColumn
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { item ->
            // Sử dụng Card để hiển thị mỗi item
            Card(modifier = Modifier
                .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .clickable {
                    Toast
                        .makeText(context, "Tên: " + item.ten, Toast.LENGTH_SHORT)
                        .show()
                }) {
                Column(modifier = Modifier.padding(5.dp)) {
                    Text(text = "Mã: " + item.ma.toString())
                    Text(text = "Tên: " + item.ten)
                    Text(text = "Lương: " + item.luong.toString())
                }
            }
        }
    }
}
