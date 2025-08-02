package com.example.moviesapp.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow


suspend fun <T> Flow<Response<T>>.collectAndHandle(
    onError: (Throwable?) -> Unit = {
        Log.e("collectAndHandle", "CollectAndHandle: $it")
    },
    onLoading: () -> Unit = {},
    stateReducer: (T) -> Unit,
) {
    collect {
        response ->
        when (response) {
            is Response.Loading -> onLoading()
            is Response.Success -> stateReducer(response.data)
            is Response.Error -> onError(response.error)
        }
    }
}