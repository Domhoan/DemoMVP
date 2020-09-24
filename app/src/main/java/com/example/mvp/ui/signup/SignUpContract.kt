package com.example.mvp.ui.signup

import com.example.mvp.data.model.user

interface SignUpContract {
    interface View{
        fun signUpSuccess(user: user)

        fun signUpFailure(error: String)
    }

    interface Presenter {
        fun handleSignUp(userName: String , passWord: String)
    }
}
