package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderScreen() {
    val sliderValue = remember { mutableStateOf(0f) }
    val sliderValues = remember { mutableStateOf(1f..20f) }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Slider(
            value = sliderValue.value,
            onValueChange = { sliderValue.value = it },
            valueRange = 0f..20f,
            steps = 10,
        )
        Text(text = sliderValue.value.toString())
        Spacer(modifier = Modifier.height(10.dp))
        RangeSlider(
            values = sliderValues.value,
            onValueChange = { sliderValues.value = it },
            valueRange = 1f..20f
        )
        Text(text = "Начало: ${sliderValues.value.start}, Конец: ${sliderValues.value.endInclusive}")
    }
}