package com.example.mvp.utils

import android.content.Context
import android.widget.Toast
import java.lang.Exception

fun Context.showToast(obj: Any) {
    val msg: String = when (obj) {
        is Int -> getString(obj)
        is Exception -> obj.message.toString()
        else -> obj.toString()
    }
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
