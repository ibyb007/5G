package com.openappslabs.fiveg.ui.navigation

import kotlinx.serialization.Serializable

sealed class AppRoutes {
    @Serializable
    data object HomeScreen : AppRoutes()
    
    @Serializable
    data object AboutScreen : AppRoutes()
}
