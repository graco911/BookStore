package com.gracodev.bookstore.repositories

import com.gracodev.bookstore.models.BestSeller
import com.gracodev.bookstore.models.BookData
import com.gracodev.bookstore.models.ResponseObject
import com.gracodev.bookstore.network.BookAPI
import com.gracodev.bookstore.network.SafeApiRequest

class BookRepository(
    private val api: BookAPI
) : SafeApiRequest() {
    suspend fun getBooks(): ResponseObject<BookData> {
        return apiRequest {
            api.getBooks()
        }
    }

    suspend fun getBestSellers(): ResponseObject<BestSeller> {
        return apiRequest {
            api.getBestSellers()
        }
    }
}