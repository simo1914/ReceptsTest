package com.example.receptstest.Presentation

import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.model.Meal

data class MealState(
    val isLoading: Boolean = false,
    val meals: List<Meal> = emptyList(),
    val error: String = ""
)
