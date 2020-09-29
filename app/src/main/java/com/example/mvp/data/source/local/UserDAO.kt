package com.example.mvp.data.source.local

import com.example.mvp.data.model.User

interface UserDAO {
    fun addUser(user: User)
    fun checkUser(userName: String) : Boolean
    fun checkUser(userName: String, passWord: String) : Boolean
}
