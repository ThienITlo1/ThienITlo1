package com.example.kotlin.ui.theme

fun main() {
    // Nhập giá trị n
    print("Nhập giá trị n: ")
    val n = readln().toInt()

    // Tính S3
    var s3 = 0.0
    for (i in 1..n) {
        s3 += i.toDouble() / (i + 1)
    }
    println("Tổng S3 = $s3")

    // Nhập giá trị x để tính S4
    print("Nhập giá trị x: ")
    val x = readln().toDouble()

    // Tính S4
    val s4 = Math.pow(x, n.toDouble())
    println("Tổng S4 = $s4")

    // Tính tổng các chữ số của n
    var sumOfDigits = 0
    var tempN = n

    while (tempN > 0) {
        sumOfDigits += tempN % 10 // Lấy chữ số cuối cùng
        tempN /= 10 // Loại bỏ chữ số cuối cùng
    }

    println("Tổng các chữ số của n = $sumOfDigits")
}
