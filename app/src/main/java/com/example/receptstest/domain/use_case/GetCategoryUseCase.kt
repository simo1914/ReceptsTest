package com.example.receptstest.domain.use_case

import com.example.receptstest.common.Resource
import com.example.receptstest.data.remote.dto.toCategory
import com.example.receptstest.domain.model.Category
import com.example.receptstest.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(
    private val repository: CategoryRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try{
            emit(Resource.Loading<List<Category>>())
            val categories = repository.getCategories().map{it.toCategory()}
            emit(Resource.Success<List<Category>>(categories))

        } catch (e: HttpException)  {
            emit(Resource.Error<List<Category>>(e.localizedMessage ?: "An unexpected error occured"))

        } catch (e: IOException)  {
            emit(Resource.Error<List<Category>>("Couldn't reach server. Check your internet connection"))

        }
    }
}