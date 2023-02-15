package com.example.lesson_jetpackcompose.screens

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun AlertDialogScreen() {
    val openDialog = remember { mutableStateOf(false) }
    Button(onClick = { openDialog.value = true }) {
        Text("Удалить", fontSize = 22.sp)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = { Text(text = "Подтверждение действия") },
            text = { Text("Вы действительно хотите удалить выбранный элемент?") },
            confirmButton = {
                Button(
                    onClick = { openDialog.value = false }
                ) { Text("Удалить") }
            },
            dismissButton = {
                Button(
                    onClick = { openDialog.value = false }
                ) { Text("Отмена") }
            },
        )
    }
}