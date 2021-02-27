package com.example.anchorbooks_sem1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class Books (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val author: String,
    val country: String,
    val imageLink: String,
    val language: String,
    val title: String = ""
    )