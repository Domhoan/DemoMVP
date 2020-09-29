package com.example.mvp.ui.main

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
        val userName = intent.extras?.getString(KEY, DEFAULT_VALUE)
        tvHelloName.text = userName
    }
    companion object{
        const val KEY = "userName"
        const val DEFAULT_VALUE = "No name"
    }

}
