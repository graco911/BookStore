package com.gracodev.bookstore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gracodev.bookstore.models.BestSeller
import com.gracodev.bookstore.models.BookData
import com.gracodev.bookstore.models.ResponseObject
import com.gracodev.bookstore.repositories.BookRepository
import com.gracodev.bookstore.utils.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class BookViewModel(
    private val repository: BookRepository
) : ViewModelBase() {

    val _counter = MutableLiveData<String>()
    val counter: LiveData<String> get() = _counter

    val getBooksReponse = MutableLiveData<Event<ResponseObject<BookData>>>()
    val getBestSellersReponse = MutableLiveData<Event<ResponseObject<BestSeller>>>()


    suspend fun getBooks() {
        try {
            withContext(Dispatchers.IO) {
                isBusy.postValue(true)
                getBooksReponse.postValue(
                    Event(
                        repository.getBooks()
                    )
                )
                isBusy.postValue(false)
            }
        } catch (e: Exception) {
            isBusy.value = false
            errorMessage.value = Event(e.message.toString())
        }
    }

    suspend fun getBestSellers() {
        try {
            withContext(Dispatchers.IO) {
                isBusy.postValue(true)
                getBestSellersReponse.postValue(
                    Event(
                        repository.getBestSellers()
                    )
                )
                isBusy.postValue(false)
            }
        } catch (e: Exception) {
            isBusy.value = false
            errorMessage.value = Event(e.message.toString())
        }
    }

    fun setCounterValue(size: Int) {
        _counter.value = size.toString()
    }
}