package com.example.receptstest.Presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.receptstest.common.Constants
import com.example.receptstest.common.Resource
import com.example.receptstest.domain.use_case.GetMealUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MealViewModel @Inject constructor(
    private val getMealUseCase: GetMealUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _state= mutableStateOf(MealState())
    val state : State<MealState> = _state

    init {
        val strCategory = savedStateHandle.get<String>(Constants.PARAM_MEAL_STR)
        Log.d("MealViewModel", "SavedStateHandle strCategory: $strCategory")
           strCategory?.let { strCategory ->
            getMeal(strCategory)
        }
    }

    // tuk beshe napisano greshno strCategory beshe : strCategrory
    private fun getMeal(strCategory: String) {
        Log.d("MealViewModel", "Starting API call with category: $strCategory")
        getMealUseCase(strCategory).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    Log.d("MealViewModel", "API call success: ${result.data}")
                    _state.value = MealState(
                        meals = result.data ?: emptyList()
                    )
                }
                is Resource.Error -> {
                    Log.e("MealViewModel", "API call error: ${result.message}")
                    _state.value = MealState(
                        error = result.message ?: "An unexpected error occured"
                    )

                }
                is Resource.Loading -> {
                    Log.d("MealViewModel", "API call loading")
                    _state.value = MealState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}