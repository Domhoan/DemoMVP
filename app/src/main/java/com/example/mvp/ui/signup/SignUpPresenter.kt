package com.example.mvp.ui.signup

import com.example.mvp.data.model.User
import com.example.mvp.data.source.UserRepository
import com.example.mvp.data.source.local.db.OnDataLoadedCallback
import java.lang.Exception

class SignUpPresenter(
    private var view: SignUpContract.View,
    private val repository: UserRepository
) : SignUpContract.Presenter {


    override fun handleSignUp(userName: String, passWord: String, rePass: String) {

        val success = "Sign up success"
        val fail = "User or Password is not invalid"

        if (userName.isEmpty() || passWord.isEmpty() || rePass.isEmpty() || passWord != rePass) {
            view.signUpFailure(fail)
            return
        }

        if (repository.isExistUser(userName)) {
            val user = User(userName = userName, passWord = passWord)
            repository.insertUser(user, object : OnDataLoadedCallback<Boolean> {
                override fun onSuccess(data: Boolean) {
                    view.signUpSuccess("")
                }

                override fun onFailure(exception: Exception) {
                    view.signUpFailure("")
                }
            })
            view.signUpSuccess(success)
            return
        }

        view.signUpFailure(fail)
    }
}
