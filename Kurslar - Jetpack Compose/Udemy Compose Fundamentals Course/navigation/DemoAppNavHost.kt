package com.example.composefundamentals.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun DemoAppNavHost(
    navController : NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen(
                //navController
                onNavigateToSecondScreen = { textString ->
                    // onNavigateToSecondScreen get String value. Add in this navigate text as an argument.
                    navController.navigate("second_screen/$textString")
                }
            )
        }
        composable(
            route = "second_screen/{inputName}",
            arguments = listOf(
                navArgument("inputName") { type = NavType.StringType }
            )
        ) {
            SecondScreen(
                textToDisplay = it.arguments?.getString("inputName").toString()
            )
        }
    }
}