package ru.kvmsoft.orange
 class Last5NewsResponse: ArrayList<LastItem>()

data class LastItem(
    val companiesAffected: List<String>,
    val date: String,
    val rate: Int,
    val text: String
)

data class LastNewResponse(
    val companiesAffected: List<String>,
    val date: String,
    val rate: Int,
    val text: String
)

class LastNewsOneMinuteResponse : ArrayList<LastNewsOneMinuteItem>()

data class LastNewsOneMinuteItem(
    val companiesAffected: List<String>,
    val date: String,
    val rate: Int,
    val text: String
)

data class InfoResponse(
    val account: Account,
    val assets: List<Asset>,
    val bids: List<Any>,
    val frozenAssets: List<Any>
)

data class Account(
    val id: Int,
    val name: String
)

data class Asset(
    val id: Int,
    val name: String,
    val quantity: Int
)

class SellStockResponse : ArrayList<SellStockResponseItem>()

data class SellStockResponseItem(
    val bids: List<Bid>,
    val id: Int,
    val ticker: String
)

data class Bid(
    val price: Long,
    val quantity: Int
)

class BuyStockResponse : ArrayList<BuyStockResponseItem>()

data class BuyStockResponseItem(
    val bids: List<Bid>,
    val id: Int,
    val ticker: String
)

class SymbolsResponse : ArrayList<SymbolsResponseItem>()

data class SymbolsResponseItem(
    val id: Int,
    val ticker: String
)

class MessageResponse : ArrayList<MessageResponseItem>()

data class MessageResponseItem(
    val message: String,
    val bidId: Int?,
    val price: Int?
)