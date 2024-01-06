package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.apk_pelayanan_publik_desa_jatirejo.api.ApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class register_akun : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jatirejodesa.000webhostapp.com/database_connect/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // Inisialisasi ApiService
    private val apiService: ApiService =
        retrofit.create(ApiService::class.java)// inisialisasi ApiService sesuai kebutuhan Anda

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_akun)

        val sudahpunyaakun = findViewById<TextView>(R.id.txt_sudah_punya_akun)
        sudahpunyaakun.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val registerButton = findViewById<Button>(R.id.btn_buat_akun)
        registerButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.edittext_username).text.toString()
            val email_nomor_hp = findViewById<EditText>(R.id.edittext_email).text.toString()
            val nik = findViewById<EditText>(R.id.edittext_nik).text.toString()
            val password = findViewById<EditText>(R.id.edittext_password).text.toString()

            // Validasi: Pastikan semua field telah diisi
            if (username.isEmpty() || email_nomor_hp.isEmpty() || nik.isEmpty() || password.isEmpty()) {
                showToast("Semua field harus diisi")
            } else {
                lifecycleScope.launch {
                    // Panggil fungsi registrasi
                    register(username, email_nomor_hp, nik, password)
                }
            }
        }
    }

    // Fungsi registrasi
    private suspend fun register(
        username: String,
        email_nomor_hp: String,
        nik: String,
        password: String
    ) {
        try {
            val response = apiService.register(username, email_nomor_hp, nik, password)

            if (response.isSuccessful) {
                val responseData = response.body()

                if (responseData?.success == true) {
                    // Pendaftaran berhasil
                    showToast(responseData.message ?: "Tanggapan kosong")

                    // Alihkan ke dashboard
                    val intent = Intent(this@register_akun, home_dashboard::class.java)
                    startActivity(intent)

                    // Jika NIK pada akun_user sama dengan NIK pada tabel penduduk
                    // Update status_akun menjadi "terdaftar" di tabel penduduk
                    lifecycleScope.launch {
                        updateStatusAkun(nik)
                    }
                } else {
                    // Pendaftaran gagal, tampilkan pesan kesalahan
                    showToast("Gagal: ${responseData?.message ?: "Terjadi kesalahan"}")
                }
            } else {
                // Tangani tanggapan yang tidak berhasil
                showToast("Gagal: ${response.errorBody()?.string() ?: "Terjadi kesalahan A"}")
            }
        } catch (e: Exception) {
            // Tangani kesalahan umum
            e.printStackTrace()
            showToast("Terjadi kesalahan B")
        }
    }

    // Fungsi untuk melakukan pembaruan status_akun di tabel penduduk
    private suspend fun updateStatusAkun(nik: String) {
        try {
            val response = apiService.updateStatusAkun(nik)

            if (response.isSuccessful) {
                // Pembaruan status_akun berhasil
                val responseData = response.body()
                showToast(responseData?.message ?: "Tanggapan kosong")
            } else {
                // Tangani tanggapan yang tidak berhasil
                showToast("Gagal: ${response.errorBody()?.string() ?: "Terjadi kesalahan C"}")
            }
        } catch (e: Exception) {
            // Tangani kesalahan umum
            e.printStackTrace()
            showToast("Terjadi kesalahan D")
        }
    }

    // Fungsi showToast untuk menampilkan pesan
    private fun showToast(message: String) {
        Toast.makeText(this@register_akun, message, Toast.LENGTH_LONG).show()
    }
}




//class register_akun : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_register_akun)
//
//        val sudahpunyaakun = findViewById<TextView>(R.id.txt_sudah_punya_akun)
//        sudahpunyaakun.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        //inten button ke home
//        val dash = findViewById<Button>(R.id.btn_buat_akun)
//        dash.setOnClickListener {
//            val intent = Intent(this, home_dashboard::class.java)
//            startActivity(intent)
//        }
//    }
//}