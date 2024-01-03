package com.example.apk_pelayanan_publik_desa_jatirejo

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class sk_meninggal_dunia : AppCompatActivity() {
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var autoCompleteTextViewSTPK: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sk_meninggal_dunia)

        //        pilih_jk
        // Inisialisasi AutoCompleteTextView
        autoCompleteTextView = findViewById(R.id.auto_complete_tv_jk)

        // Daftar opsi jenis kelamin
        val genderOptions = arrayOf("Laki-Laki", "Perempuan")

        // Buat adapter untuk AutoCompleteTextView
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genderOptions)

        // Set adapter untuk AutoCompleteTextView
        autoCompleteTextView.setAdapter(adapter)

        autoCompleteTextView.requestFocus()


        // Set listener untuk menangkap pilihan
        autoCompleteTextView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                autoCompleteTextView.showDropDown()
            }
            false
        }
//        end pilih jk

//        status perkawinan
        // Inisialisasi AutoCompleteTextView
        autoCompleteTextViewSTPK = findViewById(R.id.auto_complete_tv_status_perkawinan)

        // Daftar opsi jenis kelamin
        val OptionsSTPK = arrayOf("Sudah Kawin", "Belum Kawin")

        // Buat adapter untuk AutoCompleteTextView
        val adapterSTPK = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, OptionsSTPK)

        // Set adapter untuk AutoCompleteTextView
        autoCompleteTextViewSTPK.setAdapter(adapterSTPK)

        autoCompleteTextViewSTPK.requestFocus()


        // Set listener untuk menangkap pilihan
        autoCompleteTextViewSTPK.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                autoCompleteTextViewSTPK.showDropDown()
            }
            false
        }
//        end status perkawinan


        //edt_tgl_lahir_on_clik
        val editTextDateOfBirth = findViewById<EditText>(R.id.edittext_tgl_lahir)
        editTextDateOfBirth.setOnClickListener { showDatePickerDialog(editTextDateOfBirth) }

    }
    //date_picker_tgl_lahir
    fun showDatePickerDialog(view: View) {
        val editTextDateOfBirth = findViewById<EditText>(R.id.edittext_tgl_lahir)
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                // Tampilkan tanggal yang dipilih di dalam EditText
                editTextDateOfBirth.setText("$dayOfMonth-${monthOfYear + 1}-$year")
            },
            // Atur tanggal default (opsional)
            1990,
            0,
            1
        )
        datePickerDialog.show()
    }

}