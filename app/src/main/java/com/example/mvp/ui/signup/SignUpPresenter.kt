package com.example.mvp.ui.signup
import com.example.mvp.data.model.user

class SignUpPresenter : SignUpContract.Presenter {

    private var mView : SignUpContract.View? = null
    val listUser = mutableListOf<user>()

    fun setView(view: SignUpContract.View){
        mView = view
    }


    override fun handleSignUp(userName: String, passWord: String) {
        if(userName != " " && passWord != " "){
            val userA = user(userName,passWord)
            listUser.add(userA)
            mView?.signUpSuccess(userA)
            return
        }
        mView?.signUpFailure("User or Password is not invalid")
    }


}
