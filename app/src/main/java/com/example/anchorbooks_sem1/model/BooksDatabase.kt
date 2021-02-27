package com.example.anchorbooks_sem1.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= [Books::class], version = 1)
abstract class BooksDatabase: RoomDatabase() {
    abstract fun getBooksDao(): BooksDao

    companion object{
        @Volatile
        private var INSTANCE: BooksDatabase?=null

        fun getDatabase(context: Context): BooksDatabase{
            val tempInstance =INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    BooksDatabase::class.java,
                    "BooksDB").build()
                INSTANCE = instance
                return instance
            }
        }
    }
}





