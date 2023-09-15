package ru.kvmsoft.orange

data class BestPriceRequest(
    val quantity: Int,
    val symbolId: Int
)
data class LimitPriceRequest(
    val price: Int,
    val quantity: Int,
    val symbolId: Int
)

data class CancelOrderRequest(
    val bidId: Int
)