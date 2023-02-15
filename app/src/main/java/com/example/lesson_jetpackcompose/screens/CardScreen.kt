package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

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