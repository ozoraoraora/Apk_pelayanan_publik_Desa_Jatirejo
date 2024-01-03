package com.example.apk_pelayanan_publik_desa_jatirejo

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class sk_tidak_mampu : AppCompatActivity() {

    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var autoCompleteTextViewSTPK: AutoCompleteTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sk_tidak_mampu)

        Log.d("sk_tidak_mampu", "onCreate executed")

//        supportActionBar?.hide()


//        //dropdown_nama_txt_i_layout_auto_cplt_tv_
//        val items = listOf("Budi Prasetyo", "Hilda Gusti Fadilah", "Maya Silvia Ningsih", "dbedee dueduegd deygdueu ueduegd eudeu")
//        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete_tv)
//        val adapter = ArrayAdapter(this, R.layout.list_item_nama,items)
//        autoComplete.setAdapter(adapter)
//        autoComplete.onItemClickListener = AdapterView.OnItemClickListener {
//                adapterView, view, i, l ->
//            val itemselected = adapterView.getItemAtPosition(i)
//            //Toast.makeText(this, "Item : $itemselected", Toast.LENGTH_SHORT).show()
//        }
//
//        //dropdown_jk_txt_i_layout_auto_cplt_tv_jk
//        val jk = listOf("Laki-Laki", "Perempuan")
//        val autoCompletejk: AutoCompleteTextView = findViewById(R.id.auto_complete_tv_jk)
//        val adapterjk = ArrayAdapter<String>(this, R.layout.list_item_jk, jk) // Tambahkan list jk ke sini
//        autoCompletejk.setAdapter(adapterjk)
//        autoCompletejk.onItemClickListener = AdapterView.OnItemClickListener {
//                adapterView, view, i, l ->
//            val itemSelect = adapterView.getItemAtPosition(i).toString()
//            //Toast.makeText(this, "Selected: $itemSelect", Toast.LENGTH_SHORT).show()
//        }

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





        //coba spil gpt untuk dropdown nama dlm bentuk spinner/ list item
//        val dropdownData = listOf(
//            DropdownItem(1, "Item 1", "yahaha 1"),
//            DropdownItem(2, "Item 2", "yayahaha 2"),
//            DropdownItem(3, "Item 3", "yahahha 3")
//        )
//
//        // Membuat adapter untuk Spinner
//        val adapter = ArrayAdapter<DropdownItem>(
//            this,
//            android.R.layout.simple_spinner_item,
//            dropdownData
//        )
//
//        // Menentukan tata letak dropdown
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//
//        // Menetapkan adapter ke Spinner
//        val spinner = findViewById<Spinner>(R.id.spin_nama)
//        spinner.adapter = adapter
//
//        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
//                // Handle item yang dipilih
//                val selectedItem = parent.getItemAtPosition(position) as DropdownItem
//                Toast.makeText(applicationContext, "Selected: ${selectedItem.nama}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>) {
//                // Handle jika tidak ada yang dipilih
//            }
//        }
//        //end gpt



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