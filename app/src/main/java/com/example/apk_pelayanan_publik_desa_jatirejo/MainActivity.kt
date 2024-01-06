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
import com.example.apk_pelayanan_publik_desa_jatirejo.model.ApiResponse
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

        private val retrofit = Retrofit.Builder()

        .baseUrl("https://jatirejodesa.000webhostapp.com/database_connect/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    // Inisialisasi ApiService
        private val apiService: ApiService = retrofit.create(ApiService::class.java)// inisialisasi ApiService sesuai kebutuhan Anda


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            // intent button register
        val buatakun = findViewById<TextView>(R.id.buat_akun)
        buatakun.setOnClickListener {
            val intent = Intent(this, register_akun::class.java)
            startActivity(intent)
        }


        val loginButton = findViewById<Button>(R.id.btn_login)
        loginButton.setOnClickListener {
            val email_nomor_hp = findViewById<EditText>(R.id.edittext_email).text.toString()
            val password = findViewById<EditText>(R.id.edittext_password).text.toString()

            lifecycleScope.launch {
                // Panggil fungsi login
                login(email_nomor_hp, password)

            }
        }
    }

    private suspend fun login(email_nomor_hp: String, password: String) {
        try {
            // Panggil endpoint login
            val response: Response<ApiResponse> = apiService.login(email_nomor_hp, password)

            // Tanggapan berhasil atau gagal, tampilkan pesan di UI thread
            if (response.isSuccessful) {
                // Tanggapan berhasil, tampilkan pesan
                val responseData = response.body()

                if (responseData?.success == true) {
                    showToast(responseData.message ?: "Tanggapan kosong")

                    // Redirect ke halaman lain jika diperlukan
                    val intent = Intent(this@MainActivity, home_dashboard::class.java)
                    startActivity(intent)
                } else {
                    // Tanggapan gagal, tampilkan pesan kesalahan
                    showToast("Gagal: ${responseData?.message ?: "Terjadi kesalahan"}")
                }
            } else {
                // Handle unsuccessful response
                showToast("Gagal: ${response.errorBody()?.string() ?: "Terjadi kesalahan"}")
            }
        } catch (e: Exception) {
            // Tangani kesalahan umum
            e.printStackTrace()
            showToast("Terjadi kesalahan00")
        }
    }


    // Fungsi showToast untuk menampilkan pesan
    private fun showToast(message: String) {
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
    }
}

//yg ori dibawah
//class MainActivity : AppCompatActivity() {
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://jatirejodesa.000webhostapp.com/db_connect/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    private val apiService = retrofit.create(ApiService::class.java)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // intent button register
//        val buatakun = findViewById<TextView>(R.id.buat_akun)
//        buatakun.setOnClickListener {
//            val intent = Intent(this, register_akun::class.java)
//            startActivity(intent)
//        }
//
//        // intent button ke home
//        val home = findViewById<Button>(R.id.btn_login)
//        home.setOnClickListener {
//            // Panggil fungsi pengujian koneksi
//            lifecycleScope.launch {
//                testConnection()
//            }
//
//            val intent = Intent(this, home_dashboard::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private suspend fun testConnection() {
//        try {
//            // Panggil endpoint test_connection.php
//            val response = apiService.testConnection()
//
//            // Tanggapan berhasil atau gagal, tampilkan pesan di UI thread
//            if (response.isSuccessful) {
//                // Tanggapan berhasil, tampilkan pesan
//                val responseData = response.body()
//                showToast(responseData?.message ?: "Tanggapan kosong")
//            } else {
//                // Tanggapan gagal, tampilkan pesan kesalahan
//                val errorBody = response.errorBody()?.string()
//                showToast("Gagal: $errorBody")
//            }
//        } catch (e: Exception) {
//            // Tangani kesalahan umum
//            e.printStackTrace()
//            showToast("Terjadi kesalahan")
//        }
//    }
//
//    private fun showToast(message: String) {
//        runOnUiThread {
//            Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
//        }
//    }
//
//}

