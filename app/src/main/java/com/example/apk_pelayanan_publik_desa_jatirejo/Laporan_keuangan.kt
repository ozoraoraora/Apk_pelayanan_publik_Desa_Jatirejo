package com.example.apk_pelayanan_publik_desa_jatirejo

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy

class Laporan_keuangan : AppCompatActivity() {

    private lateinit var pdfView: PDFView
    private lateinit var downloadButton: Button
    private lateinit var yearSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan_keuangan)

        pdfView = findViewById(R.id.pdfView)
        downloadButton = findViewById(R.id.downloadButton)
        yearSpinner = findViewById(R.id.yearSpinner)

        // Daftar tahun dan nama file PDF yang sesuai
        val yearPdfMap = mapOf(
            "2021" to "Aplikasi_Sistem_Informasi_Pelayanan_Publik_Desa_Jatirejo_Berbasis_Mobile_dan_Web.pdf",
            "2022" to "realisasi_2022.pdf",
            "2023" to null,
            "2024" to null
        )

        // Ambil daftar tahun dari map
        val years = yearPdfMap.keys.toList()

        // Buat adapter untuk Spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set adapter untuk Spinner
        yearSpinner.adapter = adapter

        // Set listener untuk menangkap pilihan tahun
        yearSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>, selectedItemView: View, position: Int, id: Long) {
                val selectedYear = parentView.getItemAtPosition(position).toString()
//                showToast("Tahun yang dipilih: $selectedYear")

                // Dapatkan nama file PDF berdasarkan tahun yang dipilih
                val selectedPdf = yearPdfMap[selectedYear]

                // Periksa apakah file PDF ada
                if (selectedPdf != null) {
                    // Jika ada, muat PDF
                    loadPdf(selectedPdf)
                    downloadButton.visibility = View.VISIBLE
                } else {
                    showToast("File PDF tidak ditemukan")
                    loadPdf("")
                    downloadButton.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parentView: AdapterView<*>) {
                // Do nothing
            }
        }


        // Listener untuk tombol Download
        downloadButton.setOnClickListener {
            // Implementasi logika download PDF di sini
            Toast.makeText(this, "Download PDF", Toast.LENGTH_SHORT).show()

        }


    }
    private fun loadPdf(pdfFileName: String) {
        // Implementasi logika untuk memuat PDF sesuai nama file
        // Misalnya, menggunakan pdfView.fromAsset(pdfFileName).load()
        pdfView.fromAsset(pdfFileName)
            .defaultPage(0)
            .onLoad { nbPages: Int ->
                // Do something on PDF load complete
            }
            .onPageChange { page: Int, pageCount: Int ->
                // Do something on page change
            }
            .scrollHandle(DefaultScrollHandle(this))
            .spacing(10) // in dp
            .pageFitPolicy(FitPolicy.WIDTH)
            .load() // Tanpa argumen
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}