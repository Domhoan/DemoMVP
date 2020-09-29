package com.example.mvp.ui.signin

import android.content.Intent
import android.view.View

import com.example.mvp.R
import com.example.mvp.data.source.local.AppDatabase
import com.example.mvp.data.source.local.dao.UserDaoImpl
import com.example.mvp.ui.base.BaseActivity
import com.example.mvp.ui.main.MainActivity
import com.example.mvp.ui.signup.SignUpActivity
import com.example.mvp.utils.showToast
import kotlinx.android.synthetic.main.activiity_signin.*

class SignInActivity : BaseActivity(), SignInContract.View, View.OnClickListener {

    private var mAppDatabase : AppDatabase? = null
    private var mSignInPresenter: SignInPresenter? = null
    private var mUserDaoImpl: UserDaoImpl? = null

    override fun getLayoutResID() = R.layout.activiity_signin

    override fun init() {
        registerListener()
        initPresenter()
    }


    private fun registerListener() {
        btnLogin.setOnClickListener(this)
        tvSignUp.setOnClickListener(this)
    }

    private fun initPresenter() {
        mAppDatabase = AppDatabase.getInstance(this)
        mUserDaoImpl = UserDaoImpl.getInstance(mAppDatabase!!)
        mSignInPresenter = SignInPresenter(mAppDatabase!!)
        mSignInPresenter?.setView(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnLogin -> login()
            R.id.tvSignUp -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }
    }

    private fun login() {
        val userName = edtUserName.text.toString()
        val passWord = edtPassword.text.toString()
        mSignInPresenter?.handleSignIn(userName, passWord)
    }

    override fun signInSuccess(userName:String) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("userName", userName)
        startActivity(intent)
    }

    override fun signInFailure(error: String) {
        this.showToast(error)
    }

}
