package com.example.receptstest.data.remote.dto

import com.example.receptstest.domain.model.Category

data class CategoryDto(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)
fun CategoryDto.toCategory(): Category{
    return Category(
        idCategory = idCategory,
        strCategory = strCategory,
        strCategoryThumb = strCategoryThumb
    )
}