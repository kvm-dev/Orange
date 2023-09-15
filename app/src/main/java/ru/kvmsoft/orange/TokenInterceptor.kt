package ru.kvmsoft.orange

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class TokenInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        //rewrite the request to add bearer token
        val newRequest: Request = chain.request().newBuilder()
            .header("Authorization", "Token 64ef5ecb0bd8c64ef5ecb0bd8f")
            .build()
        return chain.proceed(newRequest)
    }
}