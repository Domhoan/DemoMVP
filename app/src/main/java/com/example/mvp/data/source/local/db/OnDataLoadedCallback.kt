package com.example.mvp.data.source.local.db

import java.lang.Exception

interface OnDataLoadedCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(exception: Exception = Exception())
}
