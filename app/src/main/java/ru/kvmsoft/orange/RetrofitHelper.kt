package ru.kvmsoft.orange

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitHelper {

    var interceptor = TokenInterceptor()
    var client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private const val BASE_URL = "https://datsorange.devteam.games/"
    private val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client)
            .build()
    }
}