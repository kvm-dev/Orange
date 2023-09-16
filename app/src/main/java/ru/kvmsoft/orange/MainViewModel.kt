package ru.kvmsoft.orange

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val last5News: MutableLiveData<Last5NewsResponse> = MutableLiveData()
    val lastMinuteNews: MutableLiveData<LastNewsOneMinuteResponse> = MutableLiveData()
    val lastNew: MutableLiveData<LastNewResponse> = MutableLiveData()
    val infoWallet: MutableLiveData<InfoResponse> = MutableLiveData()
    val buyStock: MutableLiveData<BuyStockResponse> = MutableLiveData()
    val sellStock: MutableLiveData<SellStockResponse> = MutableLiveData()
    val symbols: MutableLiveData<SymbolsResponse> = MutableLiveData()
    val itemList: MutableLiveData<List<RecyclerItem>> = MutableLiveData()


    fun getLast5News() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getLast5News()
            last5News.value = resultLocal.body()
        }
    }

    fun getLastNew() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getLastNew()
            lastNew.value = resultLocal.body()
        }
    }

    fun getLastOneMinuteNews() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getLastMinuteNews()
            lastMinuteNews.value = resultLocal.body()
        }
    }

    fun getInfo() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getWallet()
            infoWallet.value = resultLocal.body()
        }
    }

    fun getBuyStock() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getBuyStock()
            buyStock.value = resultLocal.body()
        }
    }

    fun getSellStock() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getSellStock()
            sellStock.value = resultLocal.body()
        }
    }

    fun getSymbols() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.getSymbols()
            Log.d("code response", "${resultLocal.code()}")
            symbols.value = resultLocal.body()
            Log.d("компании", "${resultLocal.body()?.size}")
        }
    }

     fun makeOrderBestPriceBuy(requst: BestPriceRequest){
        CoroutineScope(Dispatchers.IO).launch {
                val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
                val resultLocal = rLocal.makeOrderBestPriceBuy(requst)
            if(resultLocal.isSuccessful){
                val result  = resultLocal.body()
            }
            else{
                //something
            }
        }
    }

    fun makeOrderBestPriceSell(requst: BestPriceRequest){
        CoroutineScope(Dispatchers.IO).launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.makeOrderBestPriceSell(requst)
            if(resultLocal.isSuccessful){
                val result  = resultLocal.body()
            }
            else{
                //something
            }
        }
    }

    fun makeOrderLimitPriceSell(requst: LimitPriceRequest){
        CoroutineScope(Dispatchers.IO).launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.makeOrderLimitPriceSell(requst)
            if(resultLocal.isSuccessful){
                val result  = resultLocal.body()
            }
            else{
                //something
            }
        }
    }

    fun makeOrderLimitPriceBuy(requst: LimitPriceRequest){
        CoroutineScope(Dispatchers.IO).launch {
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.makeOrderLimitPriceBuy(requst)
            if(resultLocal.isSuccessful){
                val result  = resultLocal.body()
            }
            else{
                //something
            }
        }
    }

         fun createItems(){
        val recyclerItems = ArrayList<RecyclerItem>()
        val lastFiveNewsAffectedCompanies =  mutableMapOf<String, Int>()
        val lastOneNewsAffectedCompanies =  mutableMapOf<String, Int>()
        val lastNewAffectedCompanies =  mutableMapOf<String, Int>()
        val sortedBuyStock = buyStock.value
        val sortedSellStock = sellStock.value
        sortedBuyStock?.forEach {buy->
            buy.bids = buy.bids.sortedBy { it.price }
        }
        sortedSellStock?.forEach {sell->
            sell.bids = sell.bids.sortedBy { it.price }
        }

        last5News.value?.forEach {
            it.companiesAffected.forEach {ac->
                lastFiveNewsAffectedCompanies.put(ac, it.rate)
            }
        }

        lastMinuteNews.value?.forEach {
            it.companiesAffected.forEach {ac->
                lastOneNewsAffectedCompanies.put(ac, it.rate)
            }
        }
        lastNew.value?.companiesAffected?.forEach {
            lastNew.value?.rate?.let { it1 -> lastNewAffectedCompanies.put(it, it1) }
        }

        //test
        lastFiveNewsAffectedCompanies.forEach {
            Log.d("last5", "$it")
        }
        lastOneNewsAffectedCompanies.forEach {
            Log.d("last1", "$it")
        }
        lastNewAffectedCompanies.forEach {
            Log.d("last", "$it")
        }
             Log.d("symbol size", "${symbols.value?.size}")
        //test
        symbols.value?.forEach {symbol->
            Log.d("symb", "${symbol.ticker.replace("Oranges/", "")}.")
            if(lastNewAffectedCompanies.keys.contains(symbol.ticker.replace("Oranges/", "")) ||
                lastOneNewsAffectedCompanies.keys.contains(symbol.ticker.split("Oranges/")[1]) ||
                lastFiveNewsAffectedCompanies.keys.contains(symbol.ticker.split("Oranges/")[1])){
                Log.d("xxx", "build")
                recyclerItems.add(RecyclerItem(
                    companyId = symbol.id,
                    companyName = symbol.ticker.split("Oranges/")[1],
                    fiveMinRate = lastFiveNewsAffectedCompanies[symbol.ticker.split("Oranges/")[1]]?.toString()?: "0",
                    oneMinRate = lastOneNewsAffectedCompanies[symbol.ticker.split("Oranges/")[1]]?.toString()?: "0",
                    lastNewRate = lastNewAffectedCompanies[symbol.ticker.split("Oranges/")[1]]?.toString()?: "0",
                    bestBuyOfferId = sortedSellStock?.find { it.ticker==symbol.ticker }?.id?: 0,
                    bestBuyOfferPrice = sortedSellStock?.find { it.ticker==symbol.ticker.split("Oranges/")[1] }?.bids?.first()?.price?.toInt()?: 0,
                    bestBuyOfferCount = sortedSellStock?.find { it.ticker==symbol.ticker.split("Oranges/")[1] }?.bids?.first()?.quantity?: 0,
                    bestSellOfferId = sortedBuyStock?.find { it.ticker==symbol.ticker.split("Oranges/")[1] }?.id?: 0,
                    bestSellOfferPrice = sortedBuyStock?.find { it.ticker==symbol.ticker.split("Oranges/")[1] }?.bids?.last()?.price?.toInt()?:0,
                    bestSellOfferCount = sortedBuyStock?.find { it.ticker==symbol.ticker.split("Oranges/")[1] }?.bids?.last()?.quantity?:0,
                )
                )
            }
        }
             Log.d("финалочка", "${recyclerItems.size}")
             itemList.value = recyclerItems
}
    }