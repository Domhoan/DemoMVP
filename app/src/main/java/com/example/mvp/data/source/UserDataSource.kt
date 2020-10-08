package com.example.mvp.data.source

import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.db.OnDataLoadedCallback

interface UserDataSource {
    interface Local {
        fun insertUser(user: User, callback: OnDataLoadedCallback<Boolean>)

        fun isExistUser(userName: String): Boolean

        fun isExistUser(userName: String, passWord: String): Boolean
    }
}
