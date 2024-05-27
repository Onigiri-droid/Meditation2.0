package com.example.meditation

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.meditation.ui.home.HomeFragment
import retrofit2.Call
import retrofit2.Response
import java.util.regex.Pattern

class Signin : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        email = findViewById(R.id.Email)
        password = findViewById(R.id.Password)
        sharedPreferences = getSharedPreferences("main", MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun login(view: View) {
        if (email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()) {
            val log = MyRetrofit().getRetrofit()
            val getApi = log.create(ApiInterface::class.java)
            var hashMap: HashMap<String, String> = HashMap<String, String>()
            hashMap.put("email", email.text.toString())
            hashMap.put("password", password.text.toString())
            val log_call:retrofit2.Call<login> = getApi.getAuth(hashMap)

            log_call.enqueue(object : retrofit2.Callback<login> {

                override fun onResponse(call: Call<login>, response: Response<login>) {

                    if (response.isSuccessful) {
                        val intent = Intent(this@Signin, Navigate::class.java)
                        startActivity(intent)

                        val  name  = response.body()?.nickName
                        val avatar = response.body()?.avatar
                        editor.putString("name",name)
                        editor.putString("avatar",avatar)
                        editor.apply()

                    }
                }
                override fun onFailure(call: Call<login>, t: Throwable) {
                    Toast.makeText(this@Signin, t.message, Toast.LENGTH_SHORT).show()
                }
            })
        }

    }
}