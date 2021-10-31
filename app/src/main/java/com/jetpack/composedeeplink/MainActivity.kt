package com.jetpack.composedeeplink

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.jetpack.composedeeplink.ui.theme.ComposeDeepLinkTheme
import com.jetpack.composedeeplink.view.UrlScreen
import com.jetpack.composedeeplink.view.WebViewScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDeepLinkTheme {
                Surface(color = MaterialTheme.colors.background) {
                    WebPageScreen()
                }
            }
        }
    }
}

@Composable
fun WebPageScreen() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = "url"
    ) {
        composable("url") {
            UrlScreen(navController = navHostController)
        }
        composable(
            "webview/{url}",
            arguments = listOf(
                navArgument("url") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getString("url")?.let { url ->
                WebViewScreen(url = url)
            }
        }
    }
}





















