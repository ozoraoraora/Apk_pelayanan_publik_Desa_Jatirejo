package com.example.apk_pelayanan_publik_desa_jatirejo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.adapter.vootingAdapter
import com.example.apk_pelayanan_publik_desa_jatirejo.model.vooting
import com.google.android.material.snackbar.Snackbar

class vooting_tender : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vooting_tender)

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
//
//        //button intent detail pengaju 1
//        val detail1 = findViewById<Button>(R.id.btn_detail_pengaju_1)
//        detail1.setOnClickListener {
//            val intent = Intent(this, detail_pengaju_tender::class.java)
//            startActivity(intent)
//        }
//
//        //button intent detail pengaju 2
//        val detail2 = findViewById<Button>(R.id.btn_detail_pengaju_2)
//        detail2.setOnClickListener {
//            val intent = Intent(this, detail_pengaju_tender::class.java)
//            startActivity(intent)
//        }
//
//        //button intent detail pengaju 3
//        val detail3 = findViewById<Button>(R.id.btn_detail_pengaju_3)
//        detail3.setOnClickListener {
//            val intent = Intent(this, detail_pengaju_tender::class.java)
//            startActivity(intent)
//        }
//
//        // radio button
//        setupRadioGroup(listOf(radioBtn_1, radioBtn_2, radioBtn_3))
//        // end radio button


        //rc
        val pesertaItems = listOf(
            vooting(R.drawable.asal,"Ari Kusworo oauauoaoaoao", "800 juta"),
            vooting(R.drawable.asal,"Ari Kusworo oauauoaoaoao", "800 juta"),
            vooting(R.drawable.asal,"Ari Kusworo oauauoaoaoao", "800 juta")
        )

            val recyclerView: RecyclerView = findViewById(R.id.rv_voting)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = vootingAdapter(pesertaItems)
        recyclerView.adapter = adapter
        //end rc

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

        val homeDashboardLayout = findViewById<ConstraintLayout>(R.id.voteTender)

        Snackbar.make(homeDashboardLayout, itemClicked, Snackbar.LENGTH_LONG)//.setTextColor(Color.parseColor("#f78f23"))
            .setAction("Action", null).show()

        return super.onOptionsItemSelected(item)
    }

//    // radio button click
//    private fun setupRadioGroup(radioButtons: List<RadioButton>) {
//        radioButtons.forEach { radioButton ->
//            radioButton.setOnClickListener {
//                clearAllRadioButtonsExcept(radioButton)
//                handleRadioButtonSelection(radioButton)
//            }
//        }
//    }

//    private fun clearAllRadioButtonsExcept(selectedRadioButton: RadioButton) {
//        // Iterate through all radio buttons and uncheck them except the selected one
//        listOf(radioBtn_1, radioBtn_2, radioBtn_3)
//            .filter { it != selectedRadioButton }
//            .forEach { it.isChecked = false }
//    }

//    private fun handleRadioButtonSelection(selectedRadioButton: RadioButton) {
//        // Handle radio button selection here
//        when (selectedRadioButton) {
//            radioBtn_1 -> {
//                // Handle selection for CardView 1
//            }
//            radioBtn_2 -> {
//                // Handle selection for CardView 2
//            }
//            radioBtn_3 -> {
//                // Handle selection for CardView 3
//            }
//        }
//    }
}