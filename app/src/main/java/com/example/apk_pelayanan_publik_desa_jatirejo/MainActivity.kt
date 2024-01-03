package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intent button register
        val buatakun = findViewById<TextView>(R.id.buat_akun)
        buatakun.setOnClickListener {
            val intent = Intent(this, register_akun::class.java)
            startActivity(intent)
        }

        //inten button ke home
        val home = findViewById<Button>(R.id.btn_login)
        home.setOnClickListener {
            val intent = Intent(this, home_dashboard::class.java)
            startActivity(intent)
        }
    }
}