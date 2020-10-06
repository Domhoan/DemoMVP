package com.example.mvp.ui.signin

interface SignInContract {
    interface View {
        fun showSignInSuccess(success: Any)

        fun showSignInFailure(error: Any)
    }

    interface Presenter {
        fun handleSignIn(userName: String, passWord: String)
    }
}
