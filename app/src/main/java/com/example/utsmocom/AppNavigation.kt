package com.example.utsmocom

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }

        composable("dashboard") {
            DashboardScreen(navController)
        }

        composable("add_student") {
            AddStudentScreen(navController)
        }
    }
}