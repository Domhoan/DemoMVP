package com.example.mvp.data.model

import android.content.ContentValues
import android.os.Parcelable
import com.example.mvp.data.source.local.db.UserTable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val id: Int = -1,
    val userName: String,
    val passWord: String
) : Parcelable {

    fun getContentValues() = ContentValues().apply {
        put(UserTable.COLUMN_USER_NAME, userName)
        put(UserTable.COLUMN_USER_PASSWORD, passWord)
    }
}
