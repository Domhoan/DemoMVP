package com.example.mvp.ui.signup

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.mvp.R
import com.example.mvp.data.model.user
import com.example.mvp.ui.base.BaseActivity
import com.example.mvp.ui.signin.SignInActivity

class SignUpActivity : BaseActivity(),View.OnClickListener, SignUpContract.View {

    private var mSignUpName : EditText? = null
    private var mSignUpPassword : EditText? = null
    private var mSignUpRePass: EditText? = null
    private var mButtonSignUp : Button? = null
    private var mTvSignUp : TextView? = null
    private var mSignUpPresenter : SignUpPresenter? = null

    override fun getLayoutResID(): Int {
        return R.layout.activity_signup
    }

    override fun init() {
        initView()
        registerListener()
        initPresenter()
    }

    private fun initView() {
        mSignUpName = findViewById(R.id.edtSignUpName)
        mSignUpPassword = findViewById(R.id.edtSignUpPassword)
        mSignUpRePass = findViewById(R.id.edtSignUpRePass)
        mButtonSignUp = findViewById(R.id.btnSignUp)
        mTvSignUp = findViewById(R.id.tvSignup)
    }

    private fun initPresenter() {
        mSignUpPresenter = SignUpPresenter()
        mSignUpPresenter?.setView(this)
    }

    private fun registerListener() {
        mButtonSignUp?.setOnClickListener(this)
        mTvSignUp?.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnSignUp -> signup()
            R.id.tvSignup -> {
                startActivity(Intent(this, SignInActivity::class.java))
            }
        }
    }

    private fun signup() {
        val userName = mSignUpName?.text.toString()
        val passWord = mSignUpPassword?.text.toString()
        val repass = mSignUpRePass?.text.toString()
        if(userName.isEmpty() || passWord.isEmpty() || repass.isEmpty() || passWord != repass){
            Toast.makeText(this, "User or Password is incorrect !!!",Toast.LENGTH_SHORT).show()
            return
        }
        mSignUpPresenter?.handleSignUp(userName, passWord)
    }

    override fun signUpSuccess(user: user) {
        Toast.makeText(this, "Sign up success !!!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SignInActivity::class.java)
        startActivity(intent)
    }

    override fun signUpFailure(error: String) {
        Toast.makeText(this, "Username or Password is not invalid !!!", Toast.LENGTH_SHORT).show()
    }
}
