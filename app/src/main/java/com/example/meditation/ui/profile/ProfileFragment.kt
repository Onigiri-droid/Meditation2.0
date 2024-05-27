package com.example.meditation.ui.profile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.meditation.Login
import com.example.meditation.R
import com.example.meditation.Signin

//import com.example.meditation.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        val exit:TextView = root.findViewById(R.id.textView8)
        exit.setOnClickListener {
            val intent = Intent(requireContext() ,Login::class.java)
            startActivity(intent)
        }

        sharedPreferences = requireContext().getSharedPreferences("main", Context.MODE_PRIVATE)
        val textName: TextView = root.findViewById(R.id.textView9)
        val name = sharedPreferences.getString("name","no name")
        textName.text = ("$name")
        val avatar = sharedPreferences.getString("avatar","no avatar")
        val imageAvatar: ImageView = root.findViewById(R.id.imageView9)
        Glide.with(requireContext()).load(avatar).circleCrop().into(imageAvatar)

        return root

    }
}