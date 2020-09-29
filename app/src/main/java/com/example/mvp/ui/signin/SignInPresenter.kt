package com.example.mvp.ui.signin

import android.content.Context
import com.example.mvp.data.source.local.UserDatabaseLocal

class SignInPresenter(context: Context) : SignInContract.Presenter {

    private var view: SignInContract.View? = null
    private var dbLocal=  UserDatabaseLocal(context)


    fun setView(v: SignInContract.View) {
        view = v
    }

    override fun handleSignIn(userName: String, passWord: String) {
            if (dbLocal.checkUser(userName, passWord)) {
                view?.signInSuccess(userName, passWord)
                return
            }

        view?.signInFailure("User Name or Password is invalid")
    }

}
