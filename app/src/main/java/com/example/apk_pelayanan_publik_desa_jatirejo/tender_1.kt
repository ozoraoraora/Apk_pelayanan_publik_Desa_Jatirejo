package com.example.apk_pelayanan_publik_desa_jatirejo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class tender_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tender1)

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

        //intent pengajuan tender
        val tenderaju = findViewById<Button>(R.id.btn_pengajuan_tender)
        tenderaju.setOnClickListener {
            val intent = Intent(this, pengajuan_tender::class.java)
            startActivity(intent)
        }

        //intent voting tender
        val tendervote = findViewById<Button>(R.id.btn_voting_tender)
        tendervote.setOnClickListener {
            val intent = Intent(this, vooting_tender::class.java)
            startActivity(intent)
        }
    }

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
            R.id.menu_more -> {
                itemClicked = "more menu Clicked"
            }
            R.id.action_akun -> {
                itemClicked = "akun Clicked"
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

        val homeDashboardLayout = findViewById<ConstraintLayout>(R.id.vote_aju_tender)

        Snackbar.make(homeDashboardLayout, itemClicked, Snackbar.LENGTH_LONG)//.setTextColor(Color.parseColor("#f78f23"))
            .setAction("Action", null).show()

        return super.onOptionsItemSelected(item)
    }
}