package com.example.mvp.data.source

import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.db.OnDataLoadedCallback

class UserRepository private constructor(
    private val local: UserDataSource.Local
) : UserDataSource.Local {

    override fun insertUser(user: User, callback: OnDataLoadedCallback<Boolean>) {
        local.insertUser(user, callback)
    }

    override fun isExistUser(userName: String) =
        local.isExistUser(userName)

    override fun isExistUser(userName: String, passWord: String) =
        local.isExistUser(userName, passWord)

    companion object {
        private var instance: UserRepository? = null
        fun getInstance(local: UserDataSource.Local) =
            instance ?: UserRepository(local).also { instance = it }
    }
}
