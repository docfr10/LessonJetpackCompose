package com.example.lesson_jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadiobuttonScreen() {
    val languages = listOf("Kotlin", "Java", "C#", "Python")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(languages[0]) }

    Column(Modifier.selectableGroup()) {
        languages.forEach { text ->
            Row( Modifier.fillMaxWidth().height(56.dp), verticalAlignment = Alignment.CenterVertically)
            {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) }
                )
                Text( text = text, fontSize = 22.sp )
            }
        }
    }
}