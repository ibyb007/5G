package com.openappslabs.fiveg.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
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
    val onAboutClick = remember(navController) {
        {
            navController.navigate(Screen.About)
            Unit
        }
    }

    val onBackClick = remember(navController) {
        {
            navController.popBackStack()
            Unit
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Home
    ) {
        homeScreenRoute(onAboutClick = onAboutClick)
        aboutScreenRoute(onBackClick = onBackClick)
    }
}
private fun NavGraphBuilder.homeScreenRoute(onAboutClick: () -> Unit) {
    composable<Screen.Home> {
        HomeScreen(onAboutClick = onAboutClick)
    }
}

private fun NavGraphBuilder.aboutScreenRoute(onBackClick: () -> Unit) {
    composable<Screen.About> {
        AboutScreen(onBackClick = onBackClick)
    }
}