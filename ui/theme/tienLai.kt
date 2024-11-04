package com.example.kotlin.ui.theme

fun main(){
    print("Nhập giá của laptop: ")
    var soTien = readln().toInt()
    val thoiHanTra = 6
    val tienTraMoiThang = soTien / thoiHanTra
    var tienConLai = soTien
    var i = 1

    println("Tiền trả mỗi tháng : $tienTraMoiThang")
    println("Số tiền còn lại phải trả   |   Trả mỗi tháng   |   Lãi |   Tổng")
    while(i <= thoiHanTra){
        val laiMoiThang = tienConLai * 0.01
        val tong = tienTraMoiThang + laiMoiThang

        println("$tienConLai    |   $tienTraMoiThang    |   $laiMoiThang    |   $tong")
        tienConLai -= tienTraMoiThang
        i++
    }
}