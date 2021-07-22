package com.example.retrofit_demo1

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiInterface.create().getpeople()
        apiInterface.enqueue(object : Callback<List<People>>{
            override fun onResponse(call: Call<List<People>>, response: Response<List<People>>) {

                if(response?.body() != null)
                {
                    findViewById<TextView>(R.id.textview).text = response.body()!![0].address
                }
            }

            override fun onFailure(call: Call<List<People>>, t: Throwable) {

                findViewById<TextView>(R.id.textview).text = t.message.toString()
                Log.e("RETROFIT_ERROR", t.message.toString())
            }

        })


    }


}