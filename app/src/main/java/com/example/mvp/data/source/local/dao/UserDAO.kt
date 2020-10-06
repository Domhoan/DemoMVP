package com.example.mvp.data.source.local.dao

import com.example.mvp.data.model.User

interface UserDAO {
    fun addUser(user: User): Boolean
    fun isExistUser(userName: String): Boolean
    fun isExistUser(userName: String, passWord: String): Boolean
}
