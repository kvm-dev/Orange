package ru.kvmsoft.orange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(val internalData:Last5NewsResponse) : RecyclerView.Adapter<RecyclerAdapter.NewsHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val news = internalData[position]
        holder.newsName.text = news.text
    }

    override fun getItemCount(): Int = internalData.size

    class NewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        val newsName: TextView = view.findViewById(R.id.item_news_text)

    }
}