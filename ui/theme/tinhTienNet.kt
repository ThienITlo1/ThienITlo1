package com.example.kotlin.ui.theme

fun main(){
    var a = 0
    var b = 0
    var gia = 7000
    var haigiodau = 10000

    do {
        print("Giờ bắt đầu: ")
        a = readln().toInt()
        print("Giờ kết thúc: ")
        b = readln().toInt()
    } while (
        a < 7 || b > 23
    )
    var c = b - a
    println("Tổng giờ chơi: $c giờ")
    var TongTien = 20000 + ((c - 2) * 10000) * (100 - 15) / 100
    println("Cái giá phải trả: $TongTien")
    if (a >= 14 || a <= 16) {
        TongTien = TongTien * (100 - 10) / 100
        print("Tổng tiền phải trả Happy Hour: $TongTien")
    }
}