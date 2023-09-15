package ru.kvmsoft.orange

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

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

    @POST("BestPriceBuy")
    suspend fun makeOrderBestPriceBuy(
        @Body request: BestPriceRequest
    ): Response<MessageResponse>

    @POST("BestPriceSell")
    suspend fun makeOrderBestPriceSell(
        @Body request: BestPriceRequest
    ): Response<MessageResponse>

    @POST("LimitPriceBuy")
    suspend fun makeOrderLimitPriceBuy(
        @Body request: LimitPriceRequest
    ): Response<MessageResponse>

    @POST("LimitPriceSell")
    suspend fun makeOrderLimitPriceSell(
        @Body request: LimitPriceRequest
    ): Response<MessageResponse>

    @POST("RemoveBid")
    suspend fun cancelOrder(
        @Body request: CancelOrderRequest
    ): Response<String?>


}