package com.example.apk_pelayanan_publik_desa_jatirejo.adapter

import android.content.Intent
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.R
import com.example.apk_pelayanan_publik_desa_jatirejo.detail_pengaju_tender
import com.example.apk_pelayanan_publik_desa_jatirejo.model.vooting

class vootingAdapter (private val pesertaItems: List<vooting>) :
    RecyclerView.Adapter<vootingAdapter.PesertaViewHolder>() {

    // Menyimpan posisi item yang dipilih
    private var selectedItemPosition: Int = RecyclerView.NO_POSITION


    inner class PesertaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPengaju: ImageView = itemView.findViewById(R.id.img_pengajuTender)
        val txtNamaPengaju: TextView = itemView.findViewById(R.id.txt_nama_pengajuTender)
        val txtJumlahAnggaran: TextView = itemView.findViewById(R.id.txt_jlh_anggaranTender)
        val btnDetail: Button = itemView.findViewById(R.id.btn_detail_pengaju_1)
        val radioBtn: RadioButton = itemView.findViewById(R.id.radioBtn_1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PesertaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_vooting, parent, false)
        return PesertaViewHolder(itemView)
    }

//    override fun onBindViewHolder(holder: PesertaViewHolder, position: Int) {
//        val currentItem = pesertaItems[position]
//
//        // Set nilai untuk elemen-elemen di dalam cardView_main
//        holder.imgPengaju.setImageResource(currentItem.imageResId)  // Ganti dengan sumber gambar yang sesuai
//        holder.txtNamaPengaju.text = currentItem.nama
//        holder.txtJumlahAnggaran.text = currentItem.jumlahAnggaran
//
//        // Tambahkan event click untuk button
//        holder.btnDetail.setOnClickListener {
//            // Tindakan yang ingin Anda lakukan saat button diklik
//
////            Toast.makeText(
////                holder.itemView.context,
////                "Detail pengaju ${currentItem.nama} diklik!",
////                Toast.LENGTH_SHORT
////            ).show()
//
//
//            val intent = Intent(holder.itemView.context, detail_pengaju_tender::class.java)
//            holder.itemView.context.startActivity(intent)
//        }
//
//        // Tambahkan event click untuk RadioButton
//        holder.radioBtn.setOnClickListener {
//            // Tindakan yang ingin Anda lakukan saat RadioButton diklik
//            Toast.makeText(
//                holder.itemView.context,
//                "RadioButton untuk ${currentItem.nama} diklik!",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }

    override fun onBindViewHolder(holder: PesertaViewHolder, position: Int) {
        val currentItem = pesertaItems[position]

        // Set nilai untuk elemen-elemen di dalam cardView_main
        val options = BitmapFactory.Options()
        options.inSampleSize = 2 // Mengurangi ukuran gambar menjadi setengah
        val bitmap = BitmapFactory.decodeResource(holder.itemView.resources, currentItem.imageResId, options)


        // Set nilai untuk elemen-elemen di dalam cardView_main
        holder.imgPengaju.setImageBitmap(bitmap)  // Ganti dengan sumber gambar yang sesuai
        holder.txtNamaPengaju.text = currentItem.nama
        holder.txtJumlahAnggaran.text = currentItem.jumlahAnggaran

        // Tambahkan event click untuk button
        holder.btnDetail.setOnClickListener {
            val intent = Intent(holder.itemView.context, detail_pengaju_tender::class.java)
            holder.itemView.context.startActivity(intent)
        }

        // Tambahkan event click untuk RadioButton
        holder.radioBtn.setOnClickListener {
            val previousSelectedItemPosition = selectedItemPosition
            selectedItemPosition = holder.adapterPosition

            // Perbarui tampilan RadioButton untuk item yang dipilih sekarang
            notifyItemChanged(selectedItemPosition)

            // Perbarui tampilan RadioButton untuk item sebelumnya
            if (previousSelectedItemPosition != RecyclerView.NO_POSITION) {
                notifyItemChanged(previousSelectedItemPosition)
            }

            // Hapus Toast atau biarkan kosong jika tidak ingin menampilkannya
        }

        // Set status RadioButton berdasarkan item yang dipilih
        holder.radioBtn.isChecked = position == selectedItemPosition
    }



    override fun getItemCount() = pesertaItems.size
}