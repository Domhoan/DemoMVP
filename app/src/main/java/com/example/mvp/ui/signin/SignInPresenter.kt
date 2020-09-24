package com.example.mvp.ui.signin

import com.example.mvp.data.model.user

class SignInPresenter: SignInContract.Presenter {

    private var mView : SignInContract.View? = null
    val listUser = mutableListOf<user>()


    fun setView(view: SignInContract.View){
        mView = view
    }

    override fun handleSignIn( userName: String, passWord : String) {
        for(userX in listUser!!) {
            if (userName == userX.userName && passWord == userX.passWord) {
                mView?.signInSuccess(userX)
                return
            }
        }
        mView?.signInFailure("User Name or Password")
    }

}
