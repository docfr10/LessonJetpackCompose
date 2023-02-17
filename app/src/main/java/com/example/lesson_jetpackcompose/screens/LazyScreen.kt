package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LazyScreen(navController: NavHostController) {
    val itemsList = (0..100).toList()
    val itemsIndexedList = listOf((1..100).random())

    Scaffold(content = { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyRow {
                items(itemsList) {
                    Text("Item is $it")
                }

                item {
                    Text("Single item")
                }

                itemsIndexed(itemsIndexedList) { index, item ->
                    Text("Item at index $index is $item")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(itemsList) {
                    Text("Item is $it")
                }

                item {
                    Text("Single item")
                }

                itemsIndexed(itemsIndexedList) { index, item ->
                    Text("Item at index $index is $item")
                }
            }
        }
    }, floatingActionButton = { // Button to go to creating notifications
        FloatingActionButton(shape = CircleShape, onClick = {
            navController.navigate("splashScreen")
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add a new notification")
        }
    })
}