package com.example.anchorbooks_sem1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.anchorbooks_sem1.model.Books
import kotlinx.coroutines.launch

class BooksViewModel: ViewModel() {
    private val repository: BooksRepository

    init {
        repository = BooksRepository()
        viewModelScope.launch{
            repository.getBooksWithCoroutines()
        }
    }

    fun getFetchBooksWithCoroutines(): LiveData<List<Books>> {
        return repository.liveDataBooks
    }
}