package com.example.kotlin.ui.theme

fun main(){
    print("Nhập số A: ")
    var a = readln().toInt()
    for (i in 1..a.toString().length) {
        if (a < 10) {
            break // Nếu a đã nhỏ hơn 10, dừng vòng lặp
        }
        a /= 10 // Chia số a cho 10
    }
    println("Số đầu tiên: $a")
    for (i in 1..a.toString().length){
        if (a % 2 == 0) {
            println("A là số chẵn")
            break
        } else{
            println("A là số lẻ")
            break
        }
    }
    var strA = a.toString()
    var b = false
    for (i in 0 until strA.length - 1){
        if (strA[i] < strA[i + 1] ) {
            b = false

        }
    }
    if (b){
        println("Có giảm dần")
    }else{
        println("Không giảm dần")
    }
}
