package com.openappslabs.fiveg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.openappslabs.fiveg.ui.screens.homescreen.HomeScreen
import com.openappslabs.fiveg.ui.screens.aboutscreen.AboutScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HomeScreen
    ) {
        composable<AppRoutes.HomeScreen> {
            HomeScreen(
                onAboutClick = {
                    navController.navigate(AppRoutes.AboutScreen)
                }
            )
        }
        
        composable<AppRoutes.AboutScreen> {
            AboutScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
