package com.example.receptstest.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryTheMealDbApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    /*@GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId")coinId:String): CoinDetailDto*/
}