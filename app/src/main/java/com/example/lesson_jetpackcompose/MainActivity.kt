package com.example.lesson_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
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
            // Экран с выпадающим списком - TODO
            composable(route = "spinnerScreen") { SpinnerScreen() }
            // Экран с отмечанием флажка - TODO
            composable(route = "radiobuttonScreen") { RadiobuttonScreen() }
            // Экран с Snackbar - TODO
            composable(route = "snackbarScreen") { SnackBarScreen() }
            // Экран с Slider - TODO
            composable(route = "sliderScreen") { SliderScreen() }
            // Экран с Switch - TODO
            composable(route = "switchScreen") { SwitchScreen() }
            // Экран с AlertDialog - TODO
            composable(route = "alertDialogScreen") { AlertDialogScreen() }
            // Экран с LazyColumn - TODO
            composable(route = "lazyColumnScreen") { LazyColumnScreen() }
        })
}

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("cardScreen") }) { Text(text = "К экрану карточек") }
        Button(onClick = { navController.navigate("textFieldScreen") }) { Text(text = "К экрану ввода текста") }
        Button(onClick = { navController.navigate("spinnerScreen") }) { Text(text = "К экрану с выпадающим списком") }
        Button(onClick = { navController.navigate("radiobuttonScreen") }) { Text(text = "К экрану radio button") }
        Button(onClick = { navController.navigate("appAndTopBarScreen") }) { Text(text = "К экрану topbar и appbar") }
        Button(onClick = { navController.navigate("snackbarScreen") }) { Text(text = "К экрану с snackbar") }
        Button(onClick = { navController.navigate("sliderScreen") }) { Text(text = "К экрану c slider") }
        Button(onClick = { navController.navigate("switchScreen") }) { Text(text = "К экрану switch") }
        Button(onClick = { navController.navigate("alertDialogScreen") }) { Text(text = "К экрану с alertDialog") }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card() {
            Column(Modifier.padding(10.dp)) {
                Text("Карточка 1", fontWeight = FontWeight.W700)
                Text("Текст 1", color = Color.Gray)
            }
        }
        Card(shape = RoundedCornerShape(20.dp)) {
            Box(Modifier.padding(10.dp).background(Color.Magenta), contentAlignment = Alignment.CenterEnd) {
                Text("Текст 2", color = Color.Gray)
            }
            Box(Modifier.padding(10.dp).background(Color.Green), contentAlignment = Alignment.CenterEnd) {
                Text("Карточка 2", fontWeight = FontWeight.W700)
            }
        }
        Card(border = BorderStroke(1.dp, Color.Red)) {
            Row(Modifier.padding(10.dp)) {
                Text("Карточка 3", fontWeight = FontWeight.W700)
                Text("Текст 3", color = Color.Gray)
            }
        }
    }
}

@Composable
fun TextFieldScreen() {
    val message1 = remember { mutableStateOf("") }
    val message2 = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.End) {
        Box(modifier = Modifier.fillMaxSize(0.5f).background(Color.Green)) {
            TextField(
                value = message1.value,
                onValueChange = { message1.value = it },
                label = { Text(text = "Введите текст") },
                placeholder = { Text(text = "Не более 10 символов") }
            )
        }
        Box(modifier = Modifier.fillMaxSize(0.5f).background(Color.Magenta)) {
            OutlinedTextField(
                value = message2.value,
                onValueChange = { message2.value = it },
                singleLine = false,
                label = { Text(text = "Введите текст") }
            )
        }
    }
}

@Composable
fun SpinnerScreen() {
    TODO("Not yet implemented")
}

@Composable
fun RadiobuttonScreen() {
    TODO("Not yet implemented")
}

@Composable
fun SnackBarScreen() {
    TODO("Not yet implemented")
}

@Composable
fun SliderScreen() {
    TODO("Not yet implemented")
}

@Composable
fun SwitchScreen() {
    TODO("Not yet implemented")
}

@Composable
fun AlertDialogScreen() {
    TODO("Not yet implemented")
}

@Composable
fun LazyColumnScreen() {
    TODO("Not yet implemented")
}
