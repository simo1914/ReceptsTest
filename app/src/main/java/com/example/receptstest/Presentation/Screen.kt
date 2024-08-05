package com.example.receptstest.Presentation

sealed class Screen(val route: String){
    object CategoryListScreen: Screen("category_list_screen")
    object MealScreen: Screen("meal_screen")
}
