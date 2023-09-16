package ru.kvmsoft.orange

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeResponse()
        viewModel.getSymbols()
        viewModel.getLast5News()
        viewModel.getLastOneMinuteNews()
        viewModel.getLastNew()
        viewModel.getSellStock()
        viewModel.getBuyStock()

        val tv: Button = findViewById(R.id.tv)
        tv.setOnClickListener {
//            viewModel.getLast5News()
            Log.d("ждем", "size is ${viewModel.symbols.value?.size}")
            viewModel.createItems()
        }


        val newsManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val newsRecycler = findViewById<RecyclerView>(R.id.news_recycler)
        newsRecycler.layoutManager = newsManager

//        viewModel.refreshLatestDeal()
        viewModel.itemList.observe(this) {
            newsRecycler.adapter = RecyclerAdapter(it)
        }

    }

    private fun observeResponse() {
        viewModel.last5News.observe(this) {
            if (it != null) {
                Log.d("ответ", "${it.size}")
            }
        }
    }
//
//    private fun observeNews(): ArrayList<LastItem>? {
//        viewModel.last5News.observe(this) {
//            if (it != null) {
//                return@observe
//            }
//        }
//        return null
//    }

}
