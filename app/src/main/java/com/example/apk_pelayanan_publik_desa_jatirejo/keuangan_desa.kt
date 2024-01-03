package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class keuangan_desa : AppCompatActivity() {

    private lateinit var autoCompleteTextView: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keuangan_desa)

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

        //intent rencana anggaran
        val anggaran = findViewById<Button>(R.id.btn_rencana_anggaran)
        anggaran.setOnClickListener {
            val intent = Intent(this, rencana_anggaran::class.java)
            startActivity(intent)
        }

        //intent laporan keuangan
        val laporan = findViewById<Button>(R.id.btn_laporan_keuangan)
        laporan.setOnClickListener {
            val intent = Intent(this, Laporan_keuangan::class.java)
            startActivity(intent)
        }

    }
}