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

    fun show(){
        val userName = intent.extras?.getString("userName","I don't have a name")
        tvHelloName.text = userName
    }
}
