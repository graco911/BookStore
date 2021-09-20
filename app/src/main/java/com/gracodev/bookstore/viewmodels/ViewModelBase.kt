package com.gracodev.bookstore.viewmodels

import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gracodev.bookstore.utils.Event

open class ViewModelBase : ViewModel(), Observable {

    val statusMessage = MutableLiveData<Event<String>>()
    val errorMessage = MutableLiveData<Event<String>>()
    val isBusy = MutableLiveData(false)
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {}
}