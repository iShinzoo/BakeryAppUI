package com.example.pastryappui.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pastryappui.ui.screens.CartScreen
import com.example.pastryappui.ui.screens.DetailScreen
import com.example.pastryappui.ui.screens.HomeScreen
import com.example.pastryappui.ui.screens.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.WelcomeScreen.name,
    ) {
        composable(Route.HomeScreen.name) {
            HomeScreen(navController)
        }
        composable(Route.WelcomeScreen.name) {
            WelcomeScreen(navController)
        }
        composable(Route.DetailsScreen.name) {
            DetailScreen(navController)
        }
        composable(Route.CartScreen.name) {
            CartScreen(navController)
        }
    }
}
