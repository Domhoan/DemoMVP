package com.example.mvp.data.source.local.dao

import com.example.mvp.data.model.User

interface UserDAO {
    fun addUser(vararg user: User) : Int
    fun checkUser(userName: String) : Boolean
    fun checkUser(userName: String, passWord: String) : Boolean
}
