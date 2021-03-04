package com.example.anchorbooks_sem1

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.anchorbooks_sem1.model.Books

class BooksRepository {
    private val services = RetrofitClient.retrofitInstance()
    val liveDataBooks = MutableLiveData<List<Books>>()

    //Funcion q utiliza coroutines
    suspend fun getBooksWithCoroutines(){
        Log.d("REPOSITORY","USO CORoutines")
        try {
            val response = RetrofitClient.retrofitInstance().fetchBooksCoroutines()
            when (response.isSuccessful) {
                true -> response.body()?.let {
                    liveDataBooks.value = it
                }
                false -> Log.d("ERROR", " ${response.code()}: ${response.errorBody()}")
            }
        } catch (t:Throwable){
            Log.d("ERROR COR",t.message.toString())
        }
    }
}