package com.example.apk_pelayanan_publik_desa_jatirejo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.R
import com.example.apk_pelayanan_publik_desa_jatirejo.model.tender

class tenderadapter(private val tenderItems: List<tender>, private val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<tenderadapter.TenderViewHolder>() {

    inner class TenderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnTender: Button = itemView.findViewById(R.id.btn_tender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenderViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_tender, parent, false)
        return TenderViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TenderViewHolder, position: Int) {
        val currentItem = tenderItems[position]

        holder.btnTender.text = currentItem.tenderName
        holder.btnTender.setOnClickListener { onItemClick(currentItem.tenderName) }
    }

    override fun getItemCount() = tenderItems.size
}