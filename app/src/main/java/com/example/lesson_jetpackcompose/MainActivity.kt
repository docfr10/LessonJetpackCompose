package com.example.lesson_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
                val isShowBottomBar = remember { mutableStateOf(false) }
                Surface(color = MaterialTheme.colorScheme.surface) {
                    Scaffold(
                        bottomBar = {
                            if (isShowBottomBar.value)
                                BottomNavigationBar(navController = navController)
                        },
                        content = { padding ->
                            AppScreen(
                                isShowBottomBar = isShowBottomBar,
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
fun AppScreen(
    navController: NavHostController,
    padding: PaddingValues,
    isShowBottomBar: MutableState<Boolean>
) {
    // Начальная "точка входа" в приложение - splashScreen
    AnimatedNavHost(
        modifier = Modifier.padding(paddingValues = padding),
        navController = navController,
        startDestination = "splashScreen",
        builder = {
            // Заставка
            composable(route = "splashScreen") {
                SplashScreen(navController = navController)
                isShowBottomBar.value = false
            }
            // Главный экран
            composable(route = "homeScreen") {
                HomeScreen(navController = navController)
                isShowBottomBar.value = true
            }
            // Экран с карточками
            composable(route = "cardScreen") {
                CardScreen()
                isShowBottomBar.value = true
            }
            // Экран с вводом текста
            composable(route = "textFieldScreen") {
                TextFieldScreen()
                isShowBottomBar.value = true
            }
            // Экран с выпадающим списком
            composable(route = "spinnerScreen") {
                SpinnerScreen()
                isShowBottomBar.value = true
            }
            // Экран с отмечанием флажка
            composable(route = "radiobuttonScreen") {
                RadiobuttonScreen()
                isShowBottomBar.value = true
            }
            // Экран с Slider
            composable(route = "sliderScreen") {
                SliderScreen()
                isShowBottomBar.value = true
            }
            // Экран с Switch
            composable(route = "switchScreen") {
                SwitchScreen()
                isShowBottomBar.value = true
            }
            // Экран с AlertDialog
            composable(route = "alertDialogScreen") {
                AlertDialogScreen()
                isShowBottomBar.value = true
            }
            // Экран с LazyColumn
            composable(route = "lazyScreen") {
                LazyScreen()
                isShowBottomBar.value = true
            }
        })
}
