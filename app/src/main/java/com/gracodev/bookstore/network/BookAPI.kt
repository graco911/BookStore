package com.gracodev.bookstore.network

import com.gracodev.bookstore.models.BestSeller
import com.gracodev.bookstore.models.BookData
import com.gracodev.bookstore.models.ResponseObject
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BookAPI {

    @GET("main/books.json")
    suspend fun getBooks(): Response<ResponseObject<BookData>>

    @GET("main/best_sellers.json")
    suspend fun getBestSellers(): Response<ResponseObject<BestSeller>>


    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): BookAPI {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://raw.githubusercontent.com/ejgteja/files/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BookAPI::class.java)
        }
    }

}