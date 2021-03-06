package com.example.anchorbooks_sem1

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const  val URL_BASE = "https://my-json-server.typicode.com/Himuravidal/anchorBooks/"

        fun retrofitInstance():BooksInterface{
            val retrofit = Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(BooksInterface::class.java)
        }
    }
}