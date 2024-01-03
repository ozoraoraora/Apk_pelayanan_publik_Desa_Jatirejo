package com.example.apk_pelayanan_publik_desa_jatirejo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.R
import com.example.apk_pelayanan_publik_desa_jatirejo.model.beritaModel
import kotlinx.android.synthetic.main.activity_detail_berita.view.txt_title_berita
import kotlinx.android.synthetic.main.rv_berita.view.img_berita
import kotlinx.android.synthetic.main.rv_berita.view.txt_tgl_berita

class NewsAdapter(val context: Context, val list: List<beritaModel>):RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currenNews : beritaModel? = null
        var currenPosition : Int = 0

        fun setData(currennews: beritaModel, pos: Int){
            itemView.txt_title_berita.text = currennews!!.title
            itemView.txt_tgl_berita.text = currennews!!.tgl
            itemView.img_berita.setImageResource(currennews!!.image)

            this.currenNews
            this.currenPosition
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_berita, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val dataNews = list[position]
        holder.setData(dataNews, position)

        holder.itemView.setOnClickListener(){onItemClickCallback.onItemClick(list[position])}
    }

    // region 1. Event Click
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback{
        fun onItemClick(data: beritaModel)
    }

}