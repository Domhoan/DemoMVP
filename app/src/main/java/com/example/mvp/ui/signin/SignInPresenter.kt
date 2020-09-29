package com.example.mvp.ui.signin


import com.example.mvp.data.source.local.AppDatabase
import com.example.mvp.data.source.local.dao.UserDaoImpl


class SignInPresenter(appDatabase: AppDatabase) : SignInContract.Presenter {

    private var view: SignInContract.View? = null
    private var dbLocal = UserDaoImpl(appDatabase)


    fun setView(v: SignInContract.View) {
        view = v
    }

    override fun handleSignIn(userName: String, passWord: String) {
        if (userName.isEmpty() && passWord.isEmpty()) {
            val noData = "User or Password is empty !!!"
            view?.signInFailure(noData)
            return
        }
        if (dbLocal.checkUser(userName, passWord)) {
            view?.signInSuccess(userName)
            return
        }

        view?.signInFailure("User Name or Password is invalid")
    }

}
