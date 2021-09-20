package com.gracodev.bookstore.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gracodev.bookstore.repositories.BookRepository
import com.gracodev.bookstore.viewmodels.BookViewModel

class BookFactory(
    private val repository: BookRepository,
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookViewModel(repository) as T
    }
}