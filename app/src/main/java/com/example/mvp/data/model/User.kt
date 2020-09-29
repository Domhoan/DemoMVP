package com.example.mvp.data.model

import android.content.ContentValues
import com.example.mvp.data.source.local.UserTable


data class User(
    val id: Int = -1,
    val userName: String,
    val passWord: String
) {

    fun getContentValues() = ContentValues().apply {
        put(UserTable.COLUMN_USER_NAME, userName)
        put(UserTable.COLUMN_USER_PASSWORD,passWord)
    }


//    companion object {
//
//        const val TABLE_USER = "user"
//
//        const val COLUMN_USER_ID = "user_id"
//        const val COLUMN_USER_NAME = "user_name"
//        const val COLUMN_USER_PASSWORD = "user_password"
//
//    }
}
