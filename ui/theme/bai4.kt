package com.example.kotlin.ui.theme

fun main(){
    var n: Int
    do {
        println()
        print("Nhập n (n > 0): ")
        n = readln().toInt()
        if (n == 0){
            print("Kết thúc chương trình")
            break
        }
        if (n < 0){
            print("n < 0, vui lòng nhập lại!")
        } else {
            println("Các số từ 1 đến $n:")
            for(i in 1..n){
                print("$i   ")
            }
            println()
            println("Số chẵn trong khoảng từ 1 đến $n:")
            for (i in 1..n){
                if (i % 2 == 0){
                    print("$i   ")
                }
            }
            println()
            println("Các số lẻ không chia hết cho 3 trong khoảng từ 1 đến $n:")
            for (i in 1..n){
                if (i % 3 != 0 && i % 2 != 0){
                    print("$i   ")
                }
            }
            println()
            var sum = 0
            for (i in 1..n){
                sum += i
            }
            println("  -----  ")
            println("S1 = 1 + 2 + 3 + ... + $n = $sum")
            var sum2 = 0
            for (i in 1..n){
                var x = Math.pow(-1.0 , i.toDouble()).toInt() * i
                sum2 += x
            }
            println("S2 = -1 + 2 - 3 + 4 - ... + ((-1)^$n)*$n = $sum2")
        }
        if (n == 0){
            break
        }
    } while (n > 0)
}