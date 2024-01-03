package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.adapter.tenderadapter
import com.example.apk_pelayanan_publik_desa_jatirejo.model.tender

class tender_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tender_main)

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



        //rc
        val tenderItems = listOf(
            tender("Tender 1"),
            tender("Tender 2"),
            tender("Tender 3"),
            tender("Tender 4")
        )

        val recyclerView: RecyclerView = findViewById(R.id.rv_tender)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = tenderadapter(tenderItems) { tenderName ->
            // Tindakan yang ingin Anda lakukan saat tombol di klik
            val intent = Intent(this@tender_main, tender_1::class.java)

            startActivity(intent)

        }
        recyclerView.adapter = adapter
    }
        //end rc


    //Setting menu action bar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Aksi ketika menu item di klik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemClicked: String = ""

        when (item.itemId) {
            R.id.action_akun -> {
                itemClicked = "akun Clicked"

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.logout -> {

            }
            R.id.action_bantuan -> {
                itemClicked = "bantuan cliked"
            }

//            R.id.action_profil_desa -> {
//                itemClicked = "profil desa Clicked"
//            }
//
//            R.id.action_tender -> {
//                itemClicked = "tender Clicked"
//            }
//            R.id.action_pengurusan_surat -> {
//                itemClicked = "pengurusan surat Clicked"
//            }
//            R.id.action_keuangan_desa -> {
//                itemClicked = "keuangan desa Clicked"
//            }
//            R.id.action_saran_dan_masukan -> {
//                itemClicked = "saran dan masukan Clicked"
//            }
        }

        //Buat Snackbar sebagai aksi

        val homeDashboardLayout = findViewById<ConstraintLayout>(R.id.Tender)

//        Snackbar.make(homeDashboardLayout, itemClicked, Snackbar.LENGTH_LONG)//.setTextColor(Color.parseColor("#f78f23"))
//            .setAction("Action", null).show()

        return super.onOptionsItemSelected(item)
    }
}