package com.example.apk_pelayanan_publik_desa_jatirejo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import com.github.barteksc.pdfviewer.util.FitPolicy
import kotlinx.android.synthetic.main.activity_pdf_proposalview.pdffullview

class pdfProposalview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf_proposalview)

        // Gantilah "nama_file.pdf" dengan nama file PDF yang ingin Anda tampilkan
        val pdfFileName = "Aplikasi_Sistem_Informasi_Pelayanan_Publik_Desa_Jatirejo_Berbasis_Mobile_dan_Web.pdf"

        loadPdf(pdfFileName)
    }
    private fun loadPdf(pdfFileName: String) {
        pdffullview.fromAsset(pdfFileName)

            .defaultPage(0)
            .onLoad { nbPages: Int ->
                // Lakukan sesuatu ketika PDF telah dimuat
            }
            .onPageChange { page: Int, pageCount: Int ->
                // Lakukan sesuatu ketika halaman PDF berubah
            }
            .scrollHandle(DefaultScrollHandle(this))
            .spacing(10) // dalam dp
            .pageFitPolicy(FitPolicy.WIDTH)
            .enableSwipe(true) // Tambahkan ini untuk mengaktifkan swipe
            .load()
    }
}