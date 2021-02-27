package com.example.anchorbooks_sem1.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BooksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(book: Books){
    }

    @Query("SELECT * from books_table")
    fun getAllBooks(): LiveData<List<Books>>

    @Query("DELETE From books_table")
    fun deleteAllBooks()

    @Delete
    suspend fun deleteBook(book: Books)
}