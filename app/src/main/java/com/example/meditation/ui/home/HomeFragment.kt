package com.example.meditation.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meditation.*
import com.example.meditation.recadapters.FeelRecycler
import com.example.meditation.recadapters.FeelRecycler2
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        sharedPreferences = requireContext().getSharedPreferences("main",Context.MODE_PRIVATE)
        val textName: TextView = root.findViewById(R.id.textView6)
        val name = sharedPreferences.getString("name","no name")
        textName.text = ("С возвращением,$name!"  )
        val avatar = sharedPreferences.getString("avatar","no avatar")
        val imageAvatar: ImageView = root.findViewById(R.id.imageView7)
        Glide.with(requireContext()).load(avatar).circleCrop().into(imageAvatar)
        val FeelRecycler : RecyclerView = root.findViewById(R.id.feel_rec)
//        FeelRecycler.adapter = FeelRecycler(requireContext(), feelings().data_feelings)

        val feelings = MyRetrofit().getRetrofit()
        val ApiRet = feelings.create(ApiInterface::class.java)
        val QuotesCall: retrofit2.Call<feelings> = ApiRet.getFeel()
        QuotesCall.enqueue(object : retrofit2.Callback<feelings>{
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if (response.isSuccessful) {
                    FeelRecycler.adapter =
                        response.body()?.let { FeelRecycler(requireContext(),it) }
                }
            }
            override fun onFailure(call: Call<feelings>, t: Throwable){
                t.printStackTrace()
            }
        })


        val FeelRecycler2 : RecyclerView = root.findViewById(R.id.feel_rec2)
//        FeelRecycler2.adapter = FeelRecycler2(requireContext(),MyState().list)

        val quotes = MyRetrofit().getRetrofit()
        val api_ret = quotes.create(ApiInterface::class.java)
        val quotes_call: retrofit2.Call<quotes> = api_ret.getQuotes()
        quotes_call.enqueue(object : retrofit2.Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful) {
                    FeelRecycler2.adapter =
                        response.body()?.let { FeelRecycler2(requireContext(),it) }
                }
            }
            override fun onFailure(call: Call<quotes>, t: Throwable){
            t.printStackTrace()
            }
        })
        return root
    }
    }

