package com.example.mvp.ui.signup


interface SignUpContract {
    interface View {
        fun signUpSuccess(success : String)

        fun signUpFailure(error: String)
    }

    interface Presenter {
        fun handleSignUp(userName: String, passWord: String)
    }
}
