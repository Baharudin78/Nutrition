package com.baharudin.nutrition.presentation.navigation

sealed class Screen (val route : String){
    object Welcome : Screen(route = "welcome")
    object Home : Screen(route = "home")
}