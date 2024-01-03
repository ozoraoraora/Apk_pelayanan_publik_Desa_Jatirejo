package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class register_akun : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_akun)

        val sudahpunyaakun = findViewById<TextView>(R.id.txt_sudah_punya_akun)
        sudahpunyaakun.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //inten button ke home
        val dash = findViewById<Button>(R.id.btn_buat_akun)
        dash.setOnClickListener {
            val intent = Intent(this, home_dashboard::class.java)
            startActivity(intent)
        }
    }
}