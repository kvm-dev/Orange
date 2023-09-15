package ru.kvmsoft.orange

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    val viewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeResponse()
        val tv:Button = findViewById(R.id.tv)
        tv.setOnClickListener {
            viewModel.getLast5News()
        }
    }

    private fun observeResponse(){
        viewModel.last5News.observe(this) {
            if (it != null) {
                Log.d("ответ", "${it.size}")
            }
        }
    }
    }
