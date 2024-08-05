package com.example.receptstest.domain.repository

import com.example.receptstest.data.remote.dto.CategoryDto
import com.example.receptstest.data.remote.dto.MealDto
import com.example.receptstest.data.remote.dto.MealsResponse
import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.model.Meal

interface CategoryRepository {

   suspend fun getCategories(): List<Category>

   suspend fun getMealByStr(strCategory: String): List<Meal>

}