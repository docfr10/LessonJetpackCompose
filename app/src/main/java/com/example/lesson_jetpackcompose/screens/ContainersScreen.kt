package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContainersScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End
    ) {
        Text(text = "Компонент 1")
        Text(text = "Компонент 2")
        Text(text = "Компонент 3")
    }


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = "Компонент 1")
        Text(text = "Компонент 2")
        Text(text = "Компонент 3")
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd
    ) {
        Text(text = "Компонент 1", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "Компонент 2", modifier = Modifier.align(Alignment.Center))
        Text(text = "Компонент 3", modifier = Modifier.align(Alignment.TopStart))
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Заголовок", modifier = Modifier.align(Alignment.End))
            Text(text = "Описание карточки")
        }
    }
}