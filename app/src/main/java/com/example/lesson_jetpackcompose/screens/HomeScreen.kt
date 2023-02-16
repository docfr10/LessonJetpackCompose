package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("cardScreen")
        }) { Text(text = "К экрану карточек") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("textFieldScreen")
        }) { Text(text = "К экрану ввода текста") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("spinnerScreen")
        }) { Text(text = "К экрану с выпадающим списком") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("radiobuttonScreen")
        }) { Text(text = "К экрану radio button") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("sliderScreen")
        }) { Text(text = "К экрану c slider") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("switchScreen")
        }) { Text(text = "К экрану switch") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("alertDialogScreen")
        }) { Text(text = "К экрану с alertDialog") }
        Button(onClick = {
            navController.popBackStack()
            navController.navigate("lazyScreen")
        }) { Text(text = "К экрану с lazyScreen") }
    }
}
