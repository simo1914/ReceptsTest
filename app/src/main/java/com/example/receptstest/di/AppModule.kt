package com.example.receptstest.di

import com.example.receptstest.common.Constants
import com.example.receptstest.data.remote.dto.CategoryTheMealDbApi
import com.example.receptstest.data.repository.CategoryRepositoryImpl
import com.example.receptstest.domain.repository.CategoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideTheMealDb(): CategoryTheMealDbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CategoryTheMealDbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMealRepository(api: CategoryTheMealDbApi): CategoryRepository {
        return CategoryRepositoryImpl(api)
    }
}