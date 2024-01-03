package com.example.apk_pelayanan_publik_desa_jatirejo
import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail_pengaju_tender.pdfViewproposal


class detail_pengaju_tender : AppCompatActivity() {

//    private lateinit var pdfView: PDFView
//    private lateinit var downloadButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_pengaju_tender)

        // Gantilah "nama_file.pdf" dengan nama file PDF yang ingin Anda tampilkan
        val pdfFileName = "Aplikasi_Sistem_Informasi_Pelayanan_Publik_Desa_Jatirejo_Berbasis_Mobile_dan_Web.pdf"

        loadPdf(pdfFileName)


        //intent ke halaman full pdf
        val fullPdf = findViewById<Button>(R.id.btn_lihat_proposal)
        fullPdf.setOnClickListener {
            val intent = Intent(this, pdfProposalview::class.java)
            startActivity(intent)
        }

        //video yt
        val webView: WebView = findViewById(R.id.webView)
        val video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/TQQJD7D6PIU?si=96bisFLf_dAXMNyT\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
        webView.loadData(video, "text/html", "utf-8")
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()



    }

    private fun loadPdf(pdfFileName: String) {
        pdfViewproposal.fromAsset(pdfFileName)

            .defaultPage(0)
            .onLoad { nbPages: Int ->
                // Lakukan sesuatu ketika PDF telah dimuat
            }
            .onPageChange { page: Int, pageCount: Int ->
                // Lakukan sesuatu ketika halaman PDF berubah
            }
//            .scrollHandle(DefaultScrollHandle(this))
//            .spacing(10) // dalam dp
//            .pageFitPolicy(FitPolicy.WIDTH)
//            .enableSwipe(true) // Tambahkan ini untuk mengaktifkan swipe
            .load()
    }

}