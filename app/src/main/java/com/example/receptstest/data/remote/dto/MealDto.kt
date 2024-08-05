package com.example.receptstest.data.remote.dto

import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.model.Meal

data class MealDto(
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String
)
fun MealDto.toMeal(): Meal {
    return Meal(
        idMeal = idMeal,
        strMeal = strMeal,
        strMealThumb = strMealThumb
    )
}

