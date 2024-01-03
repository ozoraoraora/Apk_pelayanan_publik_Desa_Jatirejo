package com.example.apk_pelayanan_publik_desa_jatirejo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.R
import com.example.apk_pelayanan_publik_desa_jatirejo.model.Aparatur

class AparaturAdapter(private val aparaturList: List<Aparatur>) :
    RecyclerView.Adapter<AparaturAdapter.AparaturViewHolder>() {

    class AparaturViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAparatur: ImageView = itemView.findViewById(R.id.img_aparatur)
        val txtNamaAparatur: TextView = itemView.findViewById(R.id.txt_nama_aparatur)
        val txtJabatanAparatur: TextView = itemView.findViewById(R.id.txt_jabatan_aparatur)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AparaturViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_aparatur, parent, false)
        return AparaturViewHolder(view)
    }

    override fun onBindViewHolder(holder: AparaturViewHolder, position: Int) {
        val aparatur = aparaturList[position]
        holder.imgAparatur.setImageResource(aparatur.imageResId)
        holder.txtNamaAparatur.text = aparatur.nama
        holder.txtJabatanAparatur.text = aparatur.jabatan
    }

    override fun getItemCount(): Int {
        return aparaturList.size
    }
}