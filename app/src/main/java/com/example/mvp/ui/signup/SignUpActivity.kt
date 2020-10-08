package com.example.mvp.ui.signup

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.mvp.R
import com.example.mvp.data.source.UserRepository
import com.example.mvp.data.source.local.UserLocalDataSource
import com.example.mvp.data.source.local.dao.UserDaoImpl
import com.example.mvp.ui.signin.SignInActivity
import com.example.mvp.utils.showToast
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity(), View.OnClickListener, SignUpContract.View {

    private var signUpPresenter: SignUpPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        init()
    }

    override fun signUpSuccess(success: String) {
        this.showToast(success)
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    override fun signUpFailure(error: String) {
        this.showToast(error)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.buttonSignUp -> signUp()
            R.id.textSignUp -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }

    private fun init() {
        registerListener()
        initPresenter()
    }

    private fun initPresenter() {
        val context: Context = baseContext ?: return
        val localDataSource: UserLocalDataSource =
            UserLocalDataSource.getInstance(UserDaoImpl.getInstance(context))
        val userRepository: UserRepository = UserRepository.getInstance(localDataSource)
        signUpPresenter = SignUpPresenter(this, userRepository)
    }

    private fun registerListener() {
        buttonSignUp.setOnClickListener(this)
        textSignUp.setOnClickListener(this)
    }


    private fun signUp() {
        val userName = editSignUpName.text.toString().trim()
        val passWord = editSignUpPassword.text.toString().trim()
        val rePass = editSignUpRePass.text.toString().trim()

        signUpPresenter?.handleSignUp(userName, passWord, rePass)
    }
}
