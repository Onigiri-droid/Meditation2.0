package com.example.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun account(view: View) {
        val intent = Intent (this,Signin::class.java)
        startActivity(intent)
    }
    fun reg(view: View) {
        val myToast = Toast.makeText(this,"На регистрацию бюджет не выделили", Toast.LENGTH_SHORT)
        myToast.show()
    }
}