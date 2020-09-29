package com.example.mvp.data.model


data class User constructor(val id: Int = -1, val userName: String, val passWord: String) {
    companion object {

        const val DATABASE_VERSION = 1

        const val DATABASE_NAME = "UserManager.db"

        const val TABLE_USER = "user"

        const val COLUMN_USER_ID = "user_id"
        const val COLUMN_USER_NAME = "user_name"
        const val COLUMN_USER_PASSWORD = "user_password"

    }
}
