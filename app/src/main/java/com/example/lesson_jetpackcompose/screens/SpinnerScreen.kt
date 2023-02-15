package com.example.lesson_jetpackcompose.screens

import android.app.TimePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SpinnerScreen() {
    val context = LocalContext.current
    // Initializing a Calendar
    val calendar = Calendar.getInstance()
    // Setting the current date
    calendar.time = Date()
    // Time format to display in OutlinedTextField
    val timeFormat: DateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    // Checking whether the button is pressed in DropDownMenu for time
    val expandedTime = remember { mutableStateOf(false) }
    // List with possible time
    val time = listOf("Morning", "Afternoon", "Evening", "Another time")
    // String for writing selected time
    val selectedTime = remember { mutableStateOf("") }
    // Size of DropDownMenu for time
    val textTimeFieldSize = remember { mutableStateOf(Size.Zero) }
    // Icon in OutlinedTextField for time
    val iconForTimePicker = if (expandedTime.value)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // DropdownMenu with date
        Box(modifier = Modifier.size(width = 165.dp, height = 85.dp)) {
            // DropdownMenu with time
            Box(modifier = Modifier.size(width = 165.dp, height = 85.dp)) {
                OutlinedTextField(
                    value = selectedTime.value,
                    isError = selectedTime.value.isEmpty(),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface),
                    singleLine = true,
                    onValueChange = { selectedTime.value = it },
                    modifier = Modifier
                        .onGloballyPositioned { coordinates ->
                            // This value is used to assign to the DropDown the same width
                            textTimeFieldSize.value = coordinates.size.toSize()
                        },
                    label = { Text(text = "Type a time") },
                    trailingIcon = {
                        Icon(
                            iconForTimePicker,
                            "contentDescription",
                            Modifier.clickable { expandedTime.value = !expandedTime.value })
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number, // Keyboard type
                        imeAction = ImeAction.Done // Keyboard action type
                    )
                )
                DropdownMenu(
                    expanded = expandedTime.value,
                    onDismissRequest = { expandedTime.value = false },
                    modifier = Modifier
                        .width(with(LocalDensity.current) { textTimeFieldSize.value.width.toDp() })
                        .fillMaxWidth(0.5f)
                ) {
                    time.forEach { label ->
                        DropdownMenuItem(onClick = {
                            when (label) {
                                "Morning" -> {
                                    calendar.set(Calendar.HOUR_OF_DAY, 7)
                                    calendar.set(Calendar.MINUTE, 0)
                                    selectedTime.value = timeFormat.format(calendar.time).toString()
                                }
                                "Afternoon" -> {
                                    calendar.set(Calendar.HOUR_OF_DAY, 13)
                                    calendar.set(Calendar.MINUTE, 0)
                                    selectedTime.value = timeFormat.format(calendar.time).toString()
                                }
                                "Evening" -> {
                                    calendar.set(Calendar.HOUR_OF_DAY, 19)
                                    calendar.set(Calendar.MINUTE, 0)
                                    selectedTime.value = timeFormat.format(calendar.time).toString()
                                }
                                "Another time" -> {
                                    TimePickerDialog(
                                        context,
                                        0,
                                        { _, mHour: Int, mMinute: Int ->
                                            calendar.set(Calendar.HOUR_OF_DAY, mHour)
                                            calendar.set(Calendar.MINUTE, mMinute)
                                            selectedTime.value =
                                                timeFormat.format(calendar.time).toString()
                                        },
                                        calendar[Calendar.HOUR_OF_DAY],
                                        calendar[Calendar.MINUTE],
                                        true
                                    ).show()
                                }
                            }
                            expandedTime.value = false
                        }, text = { Text(text = label) })
                    }
                }
                // Displaying information about required fields
                if (selectedTime.value.isEmpty()) {
                    Text(
                        text = "Required field",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(top = 67.dp, start = 15.dp)
                    )
                }
            }
        }
    }
}