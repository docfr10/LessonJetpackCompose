package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldScreen() {
    val message1 = remember { mutableStateOf("") }
    val message2 = remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.5f)) {
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(Color.Green)
            ) {
                TextField(
                    value = message1.value,
                    onValueChange = { message1.value = it },
                    label = { Text(text = "Введите текст") },
                    placeholder = { Text(text = "Вводимый текст") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Next
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(Color.Magenta)
            ) {
                OutlinedTextField(
                    value = message2.value,
                    onValueChange = { message2.value = it },
                    singleLine = false,
                    label = { Text(text = "Введите текст") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Done
                    )
                )
            }
        }
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5f)) {
            Text(text = message1.value)
            Text(text = message2.value)
        }
    }
}