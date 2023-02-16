package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LazyScreen() {
    val itemsList = (0..100).toList()
    val itemsIndexedList = listOf((1..100).random())

    Column(Modifier.fillMaxSize()) {
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
}