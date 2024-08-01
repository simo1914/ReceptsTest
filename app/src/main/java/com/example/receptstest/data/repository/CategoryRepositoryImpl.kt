package com.example.receptstest.data.repository

import com.example.receptstest.data.remote.dto.CategoryDto
import com.example.receptstest.data.remote.dto.CategoryTheMealDbApi
import com.example.receptstest.data.remote.dto.toCategory
import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val api: CategoryTheMealDbApi
) : CategoryRepository{

    override suspend fun getCategories(): List<Category> {
        return api.getCategories().categories.map { it.toCategory() }
    }

  /*  override suspend fun GetCategoriesById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }*/
}