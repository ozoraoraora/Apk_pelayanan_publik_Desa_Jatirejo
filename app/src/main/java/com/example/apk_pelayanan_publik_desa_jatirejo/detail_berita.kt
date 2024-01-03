package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_berita.img_berita
import kotlinx.android.synthetic.main.activity_detail_berita.txt_desc_berita
import kotlinx.android.synthetic.main.activity_detail_berita.txt_tgl_berita
import kotlinx.android.synthetic.main.activity_detail_berita.txt_title_berita

class detail_berita : AppCompatActivity() {

    companion object {
        const val cons_TitleNews ="cont_TitleNews"
        const val cont_PhotoNews = "cont_PhotoNews"
        const val cont_KontenNews = "cont_KontenNews"
        const val cont_tglnews = "cont_tglNews"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        supportActionBar?.hide()

        txt_title_berita.setText(intent.getStringExtra(cons_TitleNews))
        img_berita.setImageResource(intent.getStringExtra(cont_PhotoNews)!!.toInt())
        txt_tgl_berita.setText(intent.getStringExtra(cont_tglnews))
        txt_desc_berita.setText(intent.getStringExtra(cont_KontenNews))

    }
    //atur nav devicd back
    override fun onBackPressed() {
        val intenMain = Intent(this@detail_berita, berita::class.java)

        startActivity(intenMain)
        finish()
    }


}