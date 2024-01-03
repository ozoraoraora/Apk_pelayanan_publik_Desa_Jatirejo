package com.example.apk_pelayanan_publik_desa_jatirejo

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class pengurusan_surat : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengurusan_surat)

        //Atur toolbar sebagai support action bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        //Setting toolbar
        supportActionBar?.apply {
            title = "Desa Jatirejo"
            subtitle = " Aplikasi Pelayanan Publik"

            setDisplayShowCustomEnabled(true)
            setLogo(R.drawable.ic_nagan)
            setDisplayUseLogoEnabled(true)

        }

        //intent surat keterangan tidak mampu
        val sk_tdk_mampu = findViewById<Button>(R.id.btn_sk_tidak_mampu)
            sk_tdk_mampu.setOnClickListener {
                val intent = Intent(this, sk_tidak_mampu::class.java)
                startActivity(intent)
            }

        // intent surat ket domisili
        val sk_Domisili = findViewById<Button>(R.id.btn_sk_domisili)
        sk_Domisili.setOnClickListener {
            val intent = Intent(this, sk_domisili::class.java)
            startActivity(intent)
        }

        // intent surat ket md
        val sk_md = findViewById<Button>(R.id.btn_sk_meninggal_dunia)
        sk_md.setOnClickListener {
            val intent = Intent(this, sk_meninggal_dunia::class.java)
            startActivity(intent)
        }

        // intent surat ket bs menikah
        val sk_bsm = findViewById<Button>(R.id.btn_sk_bs_menikah)
        sk_bsm.setOnClickListener {
            val intent = Intent(this, sk_bs_menikah::class.java)
            startActivity(intent)
        }
    }
}