package com.example.mvp.data.source.local

import com.example.mvp.data.model.User

interface UserDataSource {

    fun insertUser(vararg user: User, callback: (Result<Int>) -> Unit)

}
