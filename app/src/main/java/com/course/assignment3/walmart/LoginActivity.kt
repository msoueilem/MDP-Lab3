package com.course.assignment3.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.course.assignment3.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
    }
}