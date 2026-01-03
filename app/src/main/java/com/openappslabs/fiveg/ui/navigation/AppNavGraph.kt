package com.openappslabs.fiveg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.openappslabs.fiveg.ui.screens.aboutscreen.AboutScreen
import com.openappslabs.fiveg.ui.screens.homescreen.HomeScreen

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        composable<Screen.Home> {
            HomeScreen(navController = navController)
        }
        composable<Screen.About> {
            AboutScreen(navController = navController)
        }
    }
}