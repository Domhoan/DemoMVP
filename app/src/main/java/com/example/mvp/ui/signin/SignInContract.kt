package com.example.mvp.ui.signin


interface SignInContract {
    interface View {
        fun signInSuccess(userName: String)

        fun signInFailure(error: String)
    }

    interface Presenter {
        fun handleSignIn(userName: String, passWord: String)
    }
}
