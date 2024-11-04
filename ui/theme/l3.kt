package com.example.kotlin.ui.theme

fun mainMenu() {
    while (true) {
        println("\n----- MENU -----")
        println("0. Thoát")
        println("1. Số hoàn thiện và Fibonacci")
        println("2. In chuỗi Fibonacci từ 1 đến n")
        println("3. Đánh đề?")
        print("Nhập lựa chọn của bạn: ")

        when (readln().toInt()) {
            0 -> {
                println("Thoát chương trình.")
                break
            }

            1 -> {
                print("Nhập n: ")
                val n = readln().toInt()
                kiemTraSoHoanThien(n)
                fibonacciSequence(n)
            }
            2 -> {
                print("Nhập n để kiểm tra số đối xứng: ")
                val n = readln().toInt()

                if (soDoiXung(n)){
                    println("$n là số đối xứng")
                } else {
                    println("$n không phải là số đối xứng")
                }
            }
            3 -> {
               print("Nhập số a: ")



               val a = readln().toInt()
               print("Nhập số b: ")
               val b = readln().toInt()
                if (kiemTraChua(a, b)){
                    println("Số $b nằm trong số $a")
                } else {
                    println("Số $b không nằm trong số $a")
                }
            }
            else -> {
                println("Lựa chọn không hợp lệ. Vui lòng chọn lại.")
            }
        }
    }
}

fun kiemTraSoHoanThien(n: Int) {
    println("Các ước của $n là:")
    for (i in 1..n) {
        if (n % i == 0) {
            print("$i   ")
        }
    }
    println()
}

fun fibonacciSequence(n: Int) {
    var so0 = 0
    var so1 = 1

    println("Chuỗi Fibonacci từ 1 đến $n: ")

    while (so0 <= n) {
        print("$so1 ")
        val so3 = so0 + so1
        so0 = so1
        so1 = so3
    }
    println()
}

fun soDoiXung(n: Int): Boolean{
    var soBanDau = n
    var soDaoNguoc = 0
    var temp = n

    while (temp > 0){
        val x = temp % 10
        soDaoNguoc = soDaoNguoc * 10 + x

        temp /= 10
    }

    return soBanDau == soDaoNguoc
}

fun doDaiSo(n: Int): Int {
    var soBanDau = n
    var doDai = 0

    while (soBanDau > 0) {
        soBanDau /= 10
        doDai++
    }

    return doDai
}

fun kiemTraChua(a: Int, b: Int): Boolean {
    var soA = a
    val lengthB = doDaiSo(b)

    while (soA > 0) {
        // Lấy phần cuối của a có cùng số chữ số với b
        val phanCuoi = soA % Math.pow(10.0, lengthB.toDouble()).toInt()

        if (phanCuoi == b) {
            return true
        }

        soA /= 10  // Bỏ chữ số cuối cùng của a
    }

    return false
}

fun main() {
    mainMenu()
}
