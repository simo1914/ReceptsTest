package com.example.receptstest.Presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receptstest.common.Resource
import com.example.receptstest.domain.use_case.GetCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CategoryListViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoryUseCase
) : ViewModel() {


    private val _state= mutableStateOf(CategoryListState())
    val state : State<CategoryListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCategoryUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CategoryListState(
                        categories = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    _state.value = CategoryListState(
                        error = result.message ?: "An unexpected error occured"
                    )

                }
                is Resource.Loading -> {
                    _state.value = CategoryListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}