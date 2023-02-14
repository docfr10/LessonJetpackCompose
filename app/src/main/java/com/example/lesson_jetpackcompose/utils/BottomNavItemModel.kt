package com.example.lesson_jetpackcompose.utils

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItemModel(
    val label: String,
    val icon: ImageVector,
    val route: String
)