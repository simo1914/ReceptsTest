package com.example.receptstest.domain.repository

import com.example.receptstest.data.remote.dto.CategoryDto

interface CategoryRepository {

    suspend fun getCategories(): List<CategoryDto>

    //suspend fun getCoinById(coinId: String): CoinDetailDto

}