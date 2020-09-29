package com.example.mvp.ui.signup

import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.AppDatabase
import com.example.mvp.data.source.local.dao.UserDaoImpl

class SignUpPresenter(appDatabase: AppDatabase) : SignUpContract.Presenter {

    private var mView: SignUpContract.View? = null
    private var dbLocal = UserDaoImpl(appDatabase)

    fun setView(view: SignUpContract.View) {
        mView = view
    }


    override fun handleSignUp(userName: String, passWord: String, rePass : String) {

        val success = "Sign up success"
        val fail = "User or Password is not invalid"

        if (userName.isEmpty() || passWord.isEmpty() || rePass.isEmpty() || passWord != rePass) {
            mView?.signUpFailure(fail)
            return
        }

        if (!dbLocal.checkUser(userName)) {
            val user = User(userName = userName, passWord = passWord )
            dbLocal.addUser(user)
            mView?.signUpSuccess(success)
            return
        }

        mView?.signUpFailure(fail)
    }


}
