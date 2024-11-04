package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class giaodien4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lazy()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Lazy() {
    data class Nhanvien(val maNV: String, val tenNV: String, val luong: Int)
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    var showDialog by remember { mutableStateOf(false) }
    var dialogMessage by remember { mutableStateOf("") }

    var maNV by remember { mutableStateOf("") }
    var tenNV by remember { mutableStateOf("") }
    var luong by remember { mutableStateOf("") }
    var editingIndex by remember { mutableStateOf<Int?>(null) }

    var list = remember {
        mutableStateListOf(
            Nhanvien("NV01", "Nguyen Van A", 5000),
            Nhanvien("NV02", "Nguyen Van B", 6000),
            Nhanvien("NV03", "Nguyen Van C", 7000),
            Nhanvien("NV04", "Nguyen Van D", 8000),
            Nhanvien("NV05", "Nguyen Van E", 9000),
        )
    }

    fun addNhanvien(MaNV: String, TenNV: String, Luong: Int) {
        if (list.any { it.maNV == MaNV }) {
            dialogMessage = "Mã nhân viên đã tồn tại"
            showDialog = true
            return
        }
        if (MaNV.isEmpty() || TenNV.isEmpty() || Luong.toString().isEmpty()) {
            dialogMessage = "Vui lòng nhập đầy đủ thông tin"
            showDialog = true
            return
        }
        try {
            list.add(Nhanvien(MaNV, TenNV, Luong))
            maNV = ""
            tenNV = ""
            luong = ""
            dialogMessage = "Thêm thành công"
            showDialog = true
        } catch (e: Exception) {
            dialogMessage = "Vui lòng nhập đầy đủ thông tin"
            showDialog = true
        }
    }

    fun updateNhanvien(MaNV: String, TenNV: String, Luong: Int, index: Int) {
        if (MaNV.isEmpty() || TenNV.isEmpty() || Luong.toString().isEmpty()) {
            dialogMessage = "Vui lòng nhập đầy đủ thông tin"
            showDialog = true
            return
        }
        try {
            val existingIndex = list.indexOfFirst { it.maNV == MaNV }
            if (existingIndex != -1 && existingIndex != index) {
                dialogMessage = "Mã nhân viên đã tồn tại"
                showDialog = true
                return
            }
            list[index] = Nhanvien(MaNV, TenNV, Luong)
            editingIndex = null
            maNV = ""
            tenNV = ""
            luong = ""
            dialogMessage = "Cập nhật thành công"
            showDialog = true
        } catch (e: Exception) {
            dialogMessage = "Vui lòng nhập đầy đủ thông tin"
            showDialog = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (editingIndex == null) {
            TextInput(screenWidth, "Mã Nhân Viên", maNV) { maNV = it }
            TextInput(screenWidth, "Tên Nhân Viên", tenNV) { tenNV = it }
            TextInput(screenWidth, "Lương Nhân Viên", luong) { luong = it }
            Button(
                onClick = {
                    addNhanvien(
                        MaNV = maNV,
                        TenNV = tenNV,
                        Luong = luong.toIntOrNull() ?: 0
                    )
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(screenWidth * 0.9f)
                    .clip(RoundedCornerShape(30.dp)),
                shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF242424))
            ) {
                Text(text = "Lưu", fontSize = 20.sp)
            }
        } else {
            val editingNhanvien = list[editingIndex!!]
            TextInput(screenWidth, "Mã Nhân Viên", maNV) { maNV = it }
            TextInput(screenWidth, "Tên Nhân Viên", tenNV) { tenNV = it }
            TextInput(screenWidth, "Lương Nhân Viên", luong) { luong = it }

            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(screenWidth * 0.9f),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        updateNhanvien(
                            MaNV = maNV,
                            TenNV = tenNV,
                            Luong = luong.toIntOrNull() ?: 0,
                            index = editingIndex!!
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "Cập nhật", fontSize = 20.sp)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Button(
                    onClick = {
                        editingIndex = null
                        maNV = ""
                        tenNV = ""
                        luong = ""
                    },
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(30.dp)),
                    shape = RoundedCornerShape(30.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(text = "Hủy", fontSize = 20.sp)
                }
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            items(list.size) {
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillParentMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillParentMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Ma NV: ${list[it].maNV}")
                            Text(text = "Ten NV: ${list[it].tenNV}")
                            Text(text = "Luong: ${list[it].luong}")
                        }
                        Spacer(modifier = Modifier.weight(1f))
                        Button(
                            onClick = {
                                maNV = list[it].maNV
                                tenNV = list[it].tenNV
                                luong = list[it].luong.toString()
                                editingIndex = it
                            },
                            modifier = Modifier.size(40.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                        ) {
                            Text(text = "Sửa", fontSize = 15.sp, color = Color.White)
                        }
                        Spacer(modifier = Modifier.size(10.dp))
                        Button(
                            onClick = {
                                list.removeAt(it)
                            },
                            modifier = Modifier.size(40.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                        ) {
                            Text(text = "Xóa", fontSize = 15.sp, color = Color.White)                        }
                    }
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Thông báo") },
            text = { Text(dialogMessage, fontSize = 20.sp) },
            confirmButton = {
                Button(onClick = { showDialog = false }) {
                    Text("Đóng")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TextInput(
    screenWidth: Dp,
    textLabel: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = TextStyle(fontSize = 25.sp, textAlign = TextAlign.Start),
        modifier = Modifier.width(screenWidth * 0.9f),
        label = { Text(text = textLabel, fontSize = 20.sp) }
    )
}