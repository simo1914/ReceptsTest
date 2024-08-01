package com.example.receptstest.domain.repository

import com.example.receptstest.data.remote.dto.CategoryDto
import com.example.receptstest.domain.model.Category

interface CategoryRepository {

   suspend fun getCategories(): List<Category>

    //suspend fun getCoinById(coinId: String): CoinDetailDto

}