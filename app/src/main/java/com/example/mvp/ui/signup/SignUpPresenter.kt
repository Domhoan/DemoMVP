package com.example.mvp.ui.signup

import android.content.Context
import com.example.mvp.data.model.User
import com.example.mvp.data.source.local.UserDatabaseLocal

class SignUpPresenter(context: Context) : SignUpContract.Presenter {

    private var mView: SignUpContract.View? = null
    private var dbLocal = UserDatabaseLocal(context)

    fun setView(view: SignUpContract.View) {
        mView = view
    }


    override fun handleSignUp(userName: String, passWord: String) {
        val success = "Sign up success"
        val fail = "User or Password is not invalid"
        if (!dbLocal.checkUser(userName)) {
            val user = User(userName = userName, passWord = passWord )
            dbLocal.addUser(user)
            mView?.signUpSuccess(success)
            return
        }
        mView?.signUpFailure(fail)
    }


}
