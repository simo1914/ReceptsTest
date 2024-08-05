package com.example.receptstest.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CategoryTheMealDbApi {
    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

    // Tva e po ideq na chata no v drugiq proekt e napraveno po dr nachin
/*    @GET("filter.php?c={strCategory}")
    suspend fun getMealByStr(@Path("strCategory") strCategory: String) : MealsResponse*/
    @GET("filter.php")
    suspend fun getMealByStr(@Query("c") strCategory: String): MealsResponse
}