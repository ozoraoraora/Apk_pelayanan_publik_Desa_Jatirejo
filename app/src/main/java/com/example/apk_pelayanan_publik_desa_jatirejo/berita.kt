package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apk_pelayanan_publik_desa_jatirejo.adapter.NewsAdapter
import com.example.apk_pelayanan_publik_desa_jatirejo.model.beritaModel
import com.example.apk_pelayanan_publik_desa_jatirejo.model.beritaModelData
import kotlinx.android.synthetic.main.activity_berita.rv_berita

class berita : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)


        val layManager = LinearLayoutManager(this)
        layManager.orientation = LinearLayoutManager.VERTICAL
        rv_berita.layoutManager = layManager
        newsAdapter = NewsAdapter(this, beritaModelData.listBerita)
        rv_berita.adapter = newsAdapter

        newsAdapter.setOnClickCallback(object : NewsAdapter.OnItemClickCallback{
            override fun onItemClick(data: beritaModel) {
                val intent = Intent(this@berita, detail_berita::class.java)
                    .apply {
                        putExtra(detail_berita.cons_TitleNews, data.title.toString())
                        putExtra(detail_berita.cont_PhotoNews, data.image.toString())
                        putExtra(detail_berita.cont_tglnews, data.tgl.toString())
                        putExtra(detail_berita.cont_KontenNews, data.description.toString())
                    }
                startActivity(intent)
                finish()
            }
        })
    }
}