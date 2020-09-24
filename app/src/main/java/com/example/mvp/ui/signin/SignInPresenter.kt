package com.example.mvp.ui.signin

import com.example.mvp.data.model.user

public class SignInPresenter: SignInContract.Presenter {

    private var mView : SignInContract.View? = null

    fun setView(view: SignInContract.View){
        mView = view
    }

    override fun handleSignIn(user: user) {
        if(user.userName == "admin" && user.passWord == "admin"){
            mView?.signInSuccess(user)
            return
        }
        mView?.signInFailure("User Name or Password")
    }

}
