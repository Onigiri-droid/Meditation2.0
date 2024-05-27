package com.example.meditation

import android.widget.Button

data class login(val id:String, val nickName:String, val avatar:String, val token:String)

data class  feelings(val success:Boolean, val data:ArrayList<data_feelings>)
data class data_feelings(val id:Int, val title:String, val image:String, val position:Int)

data class quotes(val success:Boolean, val data:ArrayList<data_quotes>)
data class data_quotes(val id:Int, val title:String, val image:String, val description:String, val button: Button)

//data class feel(val image:Int, val name_feel:String)
//class MyFeel{val list = arrayListOf(
//    feel(R.drawable.relax, "Расслабленным"),
//    feel(R.drawable.inyan_icon, "Спокойным"),
//    feel(R.drawable.budda, "Сосредоточенным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным"),
//    feel(R.drawable.ramen, "Взволнованным")
//)
//}