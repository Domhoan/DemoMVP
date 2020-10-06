package com.example.mvp.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        show()
    }

    private fun show() {
        val userName = intent.extras?.getString(EXTRA_USERNAME, DEFAULT_VALUE.toString())
        textHelloName.text = userName
    }

    companion object {
        const val EXTRA_USERNAME = "userName"
        const val DEFAULT_VALUE = R.string.text_no_name

        fun getIntent(context: Context, userName: String): Intent =
            Intent(context, MainActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, userName)
            }
    }
}
