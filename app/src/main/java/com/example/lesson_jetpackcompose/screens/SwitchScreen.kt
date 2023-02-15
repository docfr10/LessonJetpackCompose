package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchScreen() {
    val checkedState = remember { mutableStateOf(false) }
    val textColor = remember { mutableStateOf(Color.Unspecified) }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Зеленый цвет", fontSize = 22.sp, color = textColor.value)
            Switch(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                    if (checkedState.value) textColor.value = Color(0xff00695C)
                    else textColor.value = Color.Unspecified
                }
            )
        }
    }
}