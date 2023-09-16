package ru.kvmsoft.orange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val internalData: List<RecyclerItem>) :
    RecyclerView.Adapter<RecyclerAdapter.NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsHolder(view)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val orderInfo = internalData[position]

        holder.companyName.text = orderInfo.companyName
        holder.fiveMinRate.text = orderInfo.fiveMinRate
        holder.oneMinRate.text = orderInfo.oneMinRate
        holder.lastNewRate.text = orderInfo.lastNewRate
        holder.bestSellOfferCount.text = orderInfo.bestSellOfferCount.toString()
        holder.bestBuyOfferCount.text = orderInfo.bestBuyOfferCount.toString()
        holder.bestBuyOfferPrice.text = orderInfo.bestBuyOfferPrice.toString()
        holder.bestSellOfferPrice.text = orderInfo.bestSellOfferPrice.toString()

        holder.btnSell.setOnClickListener {
            //todo
        }
        holder.btnBuy.setOnClickListener {
            //todo
        }
    }

    override fun getItemCount(): Int = internalData.size

    class NewsHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val companyId: Int,
        val companyName: TextView = view.findViewById(R.id.item_company_name)
        val fiveMinRate: TextView = view.findViewById(R.id.item_fiveMinRate)
        val oneMinRate: TextView = view.findViewById(R.id.item_oneMinRate)
        val lastNewRate: TextView = view.findViewById(R.id.item_lastNewRate)

        //        val bestBuyOfferId: Int,
        val bestSellOfferPrice: TextView = view.findViewById(R.id.item_bestSellOfferPrice)
        val bestSellOfferCount: TextView = view.findViewById(R.id.item_bestSellOfferCount)

        //        val bestSellOfferId: Int,
        val bestBuyOfferPrice: TextView = view.findViewById(R.id.item_bestBuyOfferPrice)
        val bestBuyOfferCount: TextView = view.findViewById(R.id.item_bestBuyOfferCount)
        val btnSell: AppCompatButton = view.findViewById(R.id.btn_sell)
        val btnBuy: AppCompatButton = view.findViewById(R.id.btn_buy)
    }
}