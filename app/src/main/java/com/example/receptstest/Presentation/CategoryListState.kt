package com.example.receptstest.Presentation

import com.example.receptstest.domain.model.Category

data class CategoryListState (
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)