package com.example.mvp.ui.signin

import com.example.mvp.data.model.user

public interface SignInContract {
    interface View{
        fun signInSuccess(user: user)

        fun signInFailure(error: String)
    }

    interface Presenter {
        fun handleSignIn(user: user)
    }
}
