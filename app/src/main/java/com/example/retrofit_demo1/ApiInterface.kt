package com.example.retrofit_demo1

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("id")
    fun getpeople(): Call<List<People>>

    companion object {
        var BASE_URL = "http://demo9339017.mockable.io/getDemoData/"

        fun create() : ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}