package com.example.mvp.ui.signup

import android.content.Intent
import android.view.View
import com.example.mvp.R
import com.example.mvp.data.source.local.UserDatabaseLocal
import com.example.mvp.ui.base.BaseActivity
import com.example.mvp.ui.signin.SignInActivity
import com.example.mvp.utils.showToast
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity(), View.OnClickListener, SignUpContract.View {

    private val activity = this@SignUpActivity
    private var mSignUpPresenter: SignUpPresenter? = null
    private var dbLocal: UserDatabaseLocal? = null

    override fun getLayoutResID() = R.layout.activity_signup

    override fun init() {
        registerListener()
        initPresenter()
    }


    private fun initPresenter() {
        mSignUpPresenter = SignUpPresenter(activity)
        mSignUpPresenter?.setView(this)
        dbLocal = UserDatabaseLocal(activity)
    }

    private fun registerListener() {
        btnSignUp.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignUp -> signup()
            R.id.tvSignUp -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }

    private fun signup() {
        val userName = edtSignUpName.text.toString().trim()
        val passWord = edtSignUpPassword.text.toString().trim()
        val rePass = edtSignUpRePass.text.toString().trim()
        if (userName.isEmpty() || passWord.isEmpty() || rePass.isEmpty() || passWord != rePass) {
            val inCorrect = "User or Password is incorrect !!!"
            this.showToast(inCorrect)
            return
        }
        mSignUpPresenter?.handleSignUp(userName, passWord)
    }

    override fun signUpSuccess(success : String) {
        this.showToast(success)
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    override fun signUpFailure(error: String) {
        this.showToast(error)
    }
}
