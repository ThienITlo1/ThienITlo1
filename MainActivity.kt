package com.example.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin.ASM.Home
import com.example.kotlin.Lab7.home
import com.example.kotlin.Lab7.login
import com.example.kotlin.Lab7.login01
import com.example.kotlin.Lab7.otp
import com.example.kotlin.Lab7.password
import com.example.kotlin.ASM.Boarding
import com.example.kotlin.ASM.Login
import com.example.kotlin.ASM.SignUp
import com.example.kotlin.baove.dangky
import com.example.kotlin.baove.homebaove
import com.example.kotlin.de01.homeDe01
import com.example.kotlin.de01.dn

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            baove()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "boarding") {
        composable("boarding") { Boarding(navController) }
        composable("login") { Login(navController) }
        composable("register") { SignUp(navController) }
        composable("home/{id}") { backStackEntry ->
            Home(navController, backStackEntry)
        }
    }
}

@Composable
fun Lab7() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { login(navController) }
        composable("login01") { login01(navController) }
        composable("otp") { otp(navController) }
        composable("password") { password(navController) }
        composable("home") { home(navController) }
    }
}

@Composable
fun de01(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dn") {
        composable("dn") { dn(navController) }
        composable("home") { homeDe01(navController) }
    }
}

@Composable
fun baove(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "dangky") {
        composable("dangky") { dangky(navController) }
        composable("homebv") { homebaove(navController) }
    }
}
