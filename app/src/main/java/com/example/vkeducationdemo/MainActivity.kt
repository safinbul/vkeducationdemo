package com.example.vkeducationdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkeducationdemo.ui.applist.AppListScreen
import com.example.vkeducationdemo.ui.appdetails.AppDetailsScreen
import com.example.vkeducationdemo.ui.theme.VKEducationDemoTheme

private const val APP_LIST_ROUTE = "app_list"
private const val APP_DETAILS_ROUTE = "app_details"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VKEducationDemoTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = APP_LIST_ROUTE,
                ) {
                    composable(APP_LIST_ROUTE) {
                        AppListScreen(
                            onAppClick = { app ->
                                navController.navigate("$APP_DETAILS_ROUTE/${app.id}")
                            },
                        )
                    }
                    composable("$APP_DETAILS_ROUTE/{appId}") { entry ->
                        val appId = entry.arguments?.getString("appId")?.toLongOrNull() ?: 1L
                        AppDetailsScreen(
                            appId = appId,
                            onBackClick = { navController.popBackStack() },
                            onShowcaseAppClick = {
                                navController.navigate(APP_LIST_ROUTE) {
                                    popUpTo(APP_LIST_ROUTE) { inclusive = false }
                                    launchSingleTop = true
                                }
                            },
                        )
                    }
                }
            }
        }
    }
}
