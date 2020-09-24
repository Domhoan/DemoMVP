package com.example.mvp.ui.signin

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

import com.example.mvp.R
import com.example.mvp.data.model.user
import com.example.mvp.ui.base.BaseActivity
import com.example.mvp.ui.main.MainActivity
import com.example.mvp.ui.signup.SignUpActivity

public class  SignInActivity: BaseActivity(), SignInContract.View, View.OnClickListener {

    private var mTextUserName : EditText? = null
    private var mTextPassword : EditText? = null
    private  var mButtonSignIn : Button? = null
    private var mTextSignIn : TextView? = null
    private var mSignInPresenter : SignInPresenter? = null

    override fun getLayoutResID(): Int {
        return R.layout.activiity_signin
    }

    override fun init() {
        initView()
        registerListener()
        initPresenter()
    }

    private fun initView() {
        mTextUserName  = findViewById(R.id.edtUserName)
        mTextPassword = findViewById(R.id.edtPassword)
        mButtonSignIn = findViewById(R.id.btnLogin)
        mTextSignIn = findViewById(R.id.tvSignup)

    }

    private fun registerListener() {
        mButtonSignIn?.setOnClickListener(this)
        mTextSignIn?.setOnClickListener(this)
    }

    private fun initPresenter() {
        mSignInPresenter = SignInPresenter()
        mSignInPresenter?.setView(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnLogin -> login()
            R.id.tvSignup -> {
                startActivity(Intent(this, SignUpActivity::class.java))
            }
        }
    }

    private fun login() {
        val userName = mTextUserName?.text.toString()
        val passWord = mTextPassword?.text.toString()
        if(userName.isEmpty() && passWord.isEmpty()){
            Toast.makeText(this, "User or Password is empty !!!",Toast.LENGTH_SHORT).show()
            return
        }
        mSignInPresenter?.handleSignIn(userName, passWord)

    }

    override fun signInSuccess(user: user) {
        Toast.makeText(this, "Login success !!!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("userName", user.userName)
        intent.putExtra("passWord",user.passWord)
        startActivity(intent)
    }

    override fun signInFailure(error: String) {
        Toast.makeText(this, "Username or Password is incorrect !!!", Toast.LENGTH_SHORT).show()
    }


}
