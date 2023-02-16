package com.example.lesson_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lesson_jetpackcompose.screens.*
import com.example.lesson_jetpackcompose.ui.theme.LessonJetpackComposeTheme
import com.example.lesson_jetpackcompose.utils.Constants
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Тема приложения
            LessonJetpackComposeTheme {
                // Создание navController для перемещения между экранами
                val navController: NavHostController = rememberAnimatedNavController()
                Surface(color = MaterialTheme.colorScheme.surface) {
                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController = navController) },
                        content = { padding ->
                            AppScreen(
                                navController = navController,
                                padding = padding
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.BottomNavItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = { navController.navigate(navItem.route) },
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.label) },
                label = { Text(text = navItem.label) },
                alwaysShowLabel = false
            )
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppScreen(navController: NavHostController, padding: PaddingValues) {
    // Начальная "точка входа" в приложение - homeScreen
    AnimatedNavHost(
        modifier = Modifier.padding(paddingValues = padding),
        navController = navController,
        startDestination = "homeScreen",
        builder = {
            // Главный экран
            composable(route = "homeScreen") { HomeScreen(navController = navController) }
            // Экран с карточками
            composable(route = "cardScreen") { CardScreen() }
            // Экран с вводом текста
            composable(route = "textFieldScreen") { TextFieldScreen() }
            // Экран с выпадающим списком
            composable(route = "spinnerScreen") { SpinnerScreen() }
            // Экран с отмечанием флажка
            composable(route = "radiobuttonScreen") { RadiobuttonScreen() }
            // Экран с Slider - TODO
            composable(route = "sliderScreen") { SliderScreen() }
            // Экран с Switch
            composable(route = "switchScreen") { SwitchScreen() }
            // Экран с AlertDialog
            composable(route = "alertDialogScreen") { AlertDialogScreen() }
            // Экран с LazyColumn - TODO
            composable(route = "lazyScreen") { LazyScreen() }
        })
}
