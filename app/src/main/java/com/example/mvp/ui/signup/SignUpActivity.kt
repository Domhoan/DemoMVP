package com.example.mvp.ui.signup

import android.content.Intent
import android.view.View
import com.example.mvp.R
import com.example.mvp.data.source.local.AppDatabase
import com.example.mvp.data.source.local.dao.UserDaoImpl
import com.example.mvp.ui.base.BaseActivity
import com.example.mvp.ui.signin.SignInActivity
import com.example.mvp.utils.showToast
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : BaseActivity(), View.OnClickListener, SignUpContract.View {

    private var appDatabase : AppDatabase? = null
    private var mSignUpPresenter: SignUpPresenter? = null
    private var userDaoImpl: UserDaoImpl? = null

    override fun getLayoutResID() = R.layout.activity_signup

    override fun init() {
        registerListener()
        initPresenter()
    }


    private fun initPresenter() {
        appDatabase = AppDatabase.getInstance(this)
        userDaoImpl = UserDaoImpl.getInstance(appDatabase!!)
        mSignUpPresenter = SignUpPresenter(appDatabase!!)
        mSignUpPresenter?.setView(this)
    }

    private fun registerListener() {
        btnSignUp.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnSignUp -> signUp()
            R.id.tvSignUp -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }

    private fun signUp() {
        val userName = edtSignUpName.text.toString().trim()
        val passWord = edtSignUpPassword.text.toString().trim()
        val rePass = edtSignUpRePass.text.toString().trim()

        mSignUpPresenter?.handleSignUp(userName, passWord,rePass)
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
