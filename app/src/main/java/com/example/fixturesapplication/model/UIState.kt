package com.example.fixturesapplication.model

sealed class UIState <out T>{
    object LoadingState : UIState<Nothing>()
    data class SuccessState<out T>(val data: List<T>) : UIState<T>()
    data class ErrorState<out T>(val error: String) : UIState<T>()
}