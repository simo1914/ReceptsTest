package com.example.receptstest.data.repository

import com.example.receptstest.data.remote.dto.CategoryDto
import com.example.receptstest.data.remote.dto.CategoryTheMealDbApi
import com.example.receptstest.data.remote.dto.MealDto
import com.example.receptstest.data.remote.dto.MealsResponse
import com.example.receptstest.data.remote.dto.toCategory
import com.example.receptstest.data.remote.dto.toMeal
import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.model.Meal
import com.example.receptstest.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: CategoryTheMealDbApi
) : CategoryRepository{
    override suspend fun getCategories(): List<Category> {
        return api.getCategories().categories.map { it.toCategory() } // tva vuv videoto e razlichno moje tuk da ima problem
    }

    override suspend fun getMealByStr(strCategory: String): List<Meal> {
        return api.getMealByStr(strCategory).meals.map { it.toMeal() }
    }
}