package ru.kvmsoft.orange

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val result: MutableLiveData<ServerResponse> = MutableLiveData()

    fun makeRequest() {
//        CoroutineScope(Dispatchers.IO).launch {
        viewModelScope.launch {
            Log.d("work", "да")
            val rLocal = RetrofitHelper.getInstance().create(Api::class.java)
            val resultLocal = rLocal.makeRequest()
            result.value = resultLocal.body()
            Log.d("zzz_response", "is ${resultLocal.code()}")
            Log.d("work2", "да")
        }
    }
}