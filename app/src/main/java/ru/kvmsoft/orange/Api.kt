package ru.kvmsoft.orange

import retrofit2.Response
import retrofit2.http.POST

interface Api {
    @POST("art/stage/next")
    suspend fun makeRequest(): Response<ServerResponse>

}