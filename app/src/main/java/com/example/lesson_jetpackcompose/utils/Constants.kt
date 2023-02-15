package com.example.lesson_jetpackcompose.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

object Constants {
    val BottomNavItems = listOf(
        BottomNavItemModel(
            label = "Home",
            icon = Icons.Filled.Home,
            route = "homeScreen"
        ),
        BottomNavItemModel(
            label = "Card",
            icon = Icons.Filled.Call,
            route = "cardScreen"
        ),
        BottomNavItemModel(
            label = "TextField",
            icon = Icons.Filled.ThumbUp,
            route = "textFieldScreen"
        ),
        BottomNavItemModel(
            label = "Spinner",
            icon = Icons.Filled.Call,
            route = "spinnerScreen"
        ),
        BottomNavItemModel(
            label = "Radiobutton",
            icon = Icons.Filled.Refresh,
            route = "radiobuttonScreen"
        ),
        BottomNavItemModel(
            label = "Slider",
            icon = Icons.Filled.Search,
            route = "sliderScreen"
        ),
        BottomNavItemModel(
            label = "Switch",
            icon = Icons.Filled.Send,
            route = "switchScreen"
        ),
        BottomNavItemModel(
            label = "AlertDialog",
            icon = Icons.Filled.Add,
            route = "alertDialogScreen"
        ),
        BottomNavItemModel(
            label = "LazyColumn",
            icon = Icons.Filled.List,
            route = "lazyColumnScreen"
        ),
    )
}