package com.example.mvp.ui.signin

import com.example.mvp.R
import com.example.mvp.data.source.UserRepository


class SignInPresenter(
    private val view: SignInContract.View,
    private val repository: UserRepository
) : SignInContract.Presenter {


    override fun handleSignIn(userName: String, passWord: String) {
        if (userName.isEmpty() && passWord.isEmpty()) {
            view.showSignInFailure(R.string.msg_no_data)
            return
        }
        if (repository.isExistUser(userName, passWord)) {
            view.showSignInSuccess(userName)
            return
        }

        view.showSignInFailure(R.string.msg_user_pass_invalid)
    }
}
