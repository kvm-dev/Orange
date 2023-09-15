package ru.kvmsoft.orange

import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("news/LatestNews5Minutes")
    suspend fun getLast5News(): Response<Last5NewsResponse>

    @GET("news/LatestNews")
    suspend fun getLastNew(): Response<LastNewResponse>

    @GET("news/LatestNews1Minute")
    suspend fun getLastMinuteNews(): Response<LastNewsOneMinuteResponse>

    @GET("info")
    suspend fun getWallet(): Response<InfoResponse>

    @GET("sellStock")
    suspend fun getSellStock(): Response<SellStockResponse>

    @GET("buyStock")
    suspend fun getBuyStock(): Response<BuyStockResponse>

    @GET("getSymbols")
    suspend fun getSymbols(): Response<SymbolsResponse>

}