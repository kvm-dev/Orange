package ru.kvmsoft.orange

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val last5News: MutableLiveData<Last5NewsResponse> = MutableLiveData()
    val lastMinuteNews: MutableLiveData<LastNewsOneMinuteResponse> = MutableLiveData()
    val lastNew: MutableLiveData<LastNewResponse> = MutableLiveData()
    val infoWallet: MutableLiveData<InfoResponse> = MutableLiveData()
    val buyStock: MutableLiveData<BuyStockResponse> = MutableLiveData()
    val sellStock: MutableLiveData<SellStockResponse> = MutableLiveData()
    val symbols: MutableLiveData<SymbolsResponse> = MutableLiveData()


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
            symbols.value = resultLocal.body()
        }
    }


}