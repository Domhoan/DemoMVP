package com.example.mvp.ui.signin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

import com.example.mvp.R
import com.example.mvp.data.source.UserRepository
import com.example.mvp.data.source.local.UserLocalDataSource
import com.example.mvp.data.source.local.dao.UserDaoImpl
import com.example.mvp.ui.main.MainActivity
import com.example.mvp.ui.signup.SignUpActivity
import com.example.mvp.utils.showToast
import kotlinx.android.synthetic.main.activiity_signin.*

class SignInActivity : AppCompatActivity(), SignInContract.View, View.OnClickListener {

    private var signInPresenter: SignInPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiity_signin)
        init()
    }

    fun init() {
        registerListener()
        initPresenter()
    }

    private fun registerListener() {
        buttonLogin.setOnClickListener(this)
        textSignUp.setOnClickListener(this)
    }

    private fun initPresenter() {
        val context: Context = baseContext ?: return
        val localDataSource: UserLocalDataSource =
            UserLocalDataSource.getInstance(UserDaoImpl.getInstance(context))
        val userRepository: UserRepository = UserRepository.getInstance(localDataSource)
        signInPresenter = SignInPresenter(this, userRepository)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonLogin -> login()
            R.id.textSignUp -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }
    }

    private fun login() {
        val userName = editUserName.text.toString()
        val passWord = editPassword.text.toString()
        signInPresenter?.handleSignIn(userName, passWord)
    }

    override fun showSignInSuccess(success: Any) {
        startActivity(MainActivity.getIntent(this, success.toString()))
    }

    override fun showSignInFailure(error: Any) {
        showToast(error)
    }
}
