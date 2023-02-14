package com.example.lesson_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lesson_jetpackcompose.ui.theme.LessonJetpackComposeTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Тема приложения
            LessonJetpackComposeTheme {
                // Создание navController для перемещения между экранами
                val navController = rememberAnimatedNavController()
                // Создание всех маршрутов для перемещения
                AppScreen(navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppScreen(navController: NavHostController) {
    // Начальная "точка входа" в приложение - mainScreen
    AnimatedNavHost(navController = navController, startDestination = "mainScreen", builder = {
        // Главный экран
        composable(route = "mainScreen") {
            MainScreen(navController = navController)
        }
        // Экран с карточками
        composable(route = "cardScreen") {
            CardScreen()
        }
        // Экран с вводом текста
        composable(route = "textFieldScreen") {
            TextFieldScreen()
        }
    })
}

@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { navController.navigate("cardScreen") }) { Text(text = "К экрану карточек") }
        Button(onClick = { navController.navigate("textFieldScreen") }) { Text(text = "К экрану ввода текста") }
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
        Card() {
            Box(Modifier.padding(10.dp)) {
                Text("Карточка 2", fontWeight = FontWeight.W700)
                Text("Текст 2", color = Color.Gray)
            }
        }
        Card() {
            Row(Modifier.padding(10.dp)) {
                Text("Карточка 3", fontWeight = FontWeight.W700)
                Text("Текст 3", color = Color.Gray)
            }
        }
    }
}

@Composable
fun TextFieldScreen() {
    val message = remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize(0.5f)) {
        TextField(value = message.value, onValueChange = { message.value = it })
    }
}
