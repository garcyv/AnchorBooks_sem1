package com.example.anchorbooks_sem1

import com.example.anchorbooks_sem1.model.Books
import retrofit2.Response
import retrofit2.http.GET

interface BooksInterface {

    @GET("books")
    suspend fun fetchBooksCoroutines(): Response<List<Books>>

}