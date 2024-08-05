package com.example.receptstest.domain.use_case

import com.example.receptstest.common.Resource
import com.example.receptstest.data.remote.dto.toMeal
import com.example.receptstest.domain.model.Meal
import com.example.receptstest.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMealUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(strCategory: String): Flow<Resource<List<Meal>>> = flow {
        try {
            emit(Resource.Loading<List<Meal>>())
            val meal = repository.getMealByStr(strCategory)
            emit(Resource.Success<List<Meal>>(meal))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Meal>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Meal>>("Couldn't reach server. Check your internet connection."))
        }
    }
}