package com.example.mvp.data.source.local

import com.example.mvp.data.model.User
import com.example.mvp.data.source.UserDataSource
import com.example.mvp.data.source.local.dao.UserDAO
import com.example.mvp.data.source.local.db.LocalAsyncTask
import com.example.mvp.data.source.local.db.OnDataLoadedCallback

class UserLocalDataSource private constructor(
    private val userDAO: UserDAO
) : UserDataSource.Local {

    override fun insertUser(user: User, callback: OnDataLoadedCallback<Boolean>) {
        LocalAsyncTask<User, Boolean>(callback) {
            userDAO.addUser(user)
        }.execute(user)
    }

    override fun isExistUser(userName: String): Boolean =
        userDAO.isExistUser(userName)

    override fun isExistUser(
        userName: String,
        passWord: String,
    ): Boolean = userDAO.isExistUser(userName, passWord)

    companion object {
        private var instance: UserLocalDataSource? = null
        fun getInstance(userDAO: UserDAO): UserLocalDataSource =
            instance ?: UserLocalDataSource(userDAO).also { instance = it }
    }
}
