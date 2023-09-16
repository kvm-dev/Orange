package ru.kvmsoft.orange.room

data class DowngradeCompany(
    val companyId: Int,
    val companyName: String,
    val startPrice:Float,
    val currentPrice: Float,
    val targetPrice:Float,
    val downgradeRate: Int,
    val steelDownFlag:Boolean
)
