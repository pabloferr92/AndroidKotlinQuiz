package com.example.projetoandroidquiz.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projetoandroidquiz.screens.HomeScreen
import com.example.projetoandroidquiz.screens.QuizPlayScreen
import com.example.projetoandroidquiz.screens.ResultScreen
import com.example.projetoandroidquiz.viewmodel.SharedViewModel

@Composable
fun AppNav() {
    val navController = rememberNavController()
    val viewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(navController, viewModel)
        }
        composable("results") {
            ResultScreen(navController, viewModel)
        }
        composable("quiz") {
            QuizPlayScreen(navController, viewModel)
        }
    }
}