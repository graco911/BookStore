package com.gracodev.bookstore

import android.app.Application
import com.gracodev.bookstore.factories.BookFactory
import com.gracodev.bookstore.network.BookAPI
import com.gracodev.bookstore.network.NetworkConnectionInterceptor
import com.gracodev.bookstore.repositories.BookRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MainApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MainApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { BookAPI(instance()) }
        bind() from singleton { BookRepository(instance()) }
        bind() from singleton { BookFactory(instance()) }
    }
}