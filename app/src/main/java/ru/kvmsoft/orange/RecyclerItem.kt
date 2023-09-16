package ru.kvmsoft.orange

data class RecyclerItem(
    val companyId: Int,
    val companyName: String,
    val fiveMinRate:String,
    val oneMinRate: String,
    val lastNewRate: String,
    val bestBuyOfferId: Int,
    val bestSellOfferPrice: Int,
    val bestSellOfferCount:Int,
    val bestSellOfferId: Int,
    val bestBuyOfferPrice: Int,
    val bestBuyOfferCount: Int
)