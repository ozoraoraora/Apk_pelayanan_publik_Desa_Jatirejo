package com.example.apk_pelayanan_publik_desa_jatirejo.model

import com.example.apk_pelayanan_publik_desa_jatirejo.R

data class beritaModel(
    val title: String,
    val tgl: String,
    val image: Int,
    val description: String
)

object beritaModelData{

    val listBerita = listOf<beritaModel>(

        beritaModel("Transfer Antar Bank di Aceh Bakal Gratis Selama Pelaksanaan PON 2024",
            "Selasa, 28 November 2023", R.drawable.atm,
            "Pelaksanaan Pekan Olahraga Nasional (PON) XXI direncanakan akan berlangsung pada September 2024 mendatang. Selama event akbar itu berlangsung, biaya transfer antar bank di Tanah Rencong akan digratiskan.\n" +
                "Kepala Otoritas Jasa Keuangan (OJK) Aceh Yusri mengatakan, pihak perbankan dan industri jasa keuangan di Aceh akan mendukung pelaksanaan PON sehingga atlet dari luar dapat bertransaksi dengan mudah. Perbankan disebut akan terus melengkapi jaringan kantor serta layanan ATM, sistem dan kesiapan keuangan.\n" +
                "\n" +
                "\"Semua teman-teman perbankan akan mensupport selama pelaksanaan PON, biaya transfer yang terjadi antar bank di Aceh ini oleh pelaku yang ada di Aceh kita bebaskan,\" kata Yusri kepada wartawan usai kegiatan Forum Komunikasi Industri Jasa Keuangan (FK-IJK) di Banda Aceh, Selasa (28/11/2023)."),

        beritaModel("Ungkap Jaringan Sabu Asal Aceh, Polda Lampung Sita 113 Kg Sabu","Selasa, 28 November 2023", R.drawable.cth, "Direktorat Reserse Narkoba Polda Lampung berhasil mengungkap kasus narkoba jaringan Aceh. Dari sejumlah pengungkapan kasus itu, ada 113 kilogram sabu yang disita sebagai barang bukti.\n" +
                "Selain sabu, juga ada barang bukti lainnya berupa 43 kg ganja dan 1.000 butir pil ekstasi. Kapolda Lampung, Irjen Helmy Santika mengatakan pengungkapan kasus ini berlangsung dalam kurun waktu 1 bulan. Pengungkapan ini berlangsung di beberapa provinsi di antaranya Lampung, Aceh hingga Jawa Timur.\n" +
                "\n" +
                "\"Pengungkapan ini dilakukan Oktober-November 2023. Ada 30 tersangka yang kami tangkap dengan masing-masing perannya,\" kata dia kepada detikSumbagsel, Selasa (28/11/2023)."),

        beritaModel("Persiraja Dihukum Tutup Stadion untuk Suporter 2 Kali Pertandingan", "Senin, 27 Novemver 2023", R.drawable.persiraja, "Persiraja Banda Aceh mendapatkan sanksi dari Komite Disiplin (Komdis) PSSI buntut keributan saat pertandingan melawan PSMS Medan usai. Lantak laju dihukum menutup seluruh stadion untuk penonton saat menjadi tuan rumah.\n" +
                "Dilihat detikSumut dari situs PSSI, Senin (27/11/2023), keputusan itu diambil dalam sidang Komdis yang digelar 22 November. Komdis menilai Persiraja gagal menjalankan tanggung jawab menjaga ketertiban dan keamanan yang menyebabkan terganggunya keamanan dan kenyamanan perangkat pertandingan beserta tim tamu.\n" +
                "\n" +
                "\"Sanksi penutupan seluruh stadion untuk penonton (suporter) sebanyak dua pertandingan saat menjadi tuan rumah,\" tulis PSSI."),

        beritaModel("Kendaraan Mati Pajak di Aceh Bakal Tak Bisa Isi BBM Subsidi", "Jumat, 24 November 2023", R.drawable.kndrn, "BPH Migas akan memberlakukan aturan kendaraan mati pajak tidak boleh mengisi BBM subsidi. BPH Migas akan berkoordinasi dengan Pemerintah Aceh untuk menerapkan aturan itu di Tanah Rencong.\n" +
                "\"Di beberapa daerah (aturan itu) sudah berlaku. Di Aceh nanti kita akan berdiskusi dengan pemerintah daerah dari atas dulu dari Pj gubernur,\" kata Anggota Komite BPH Migas Abdul Halim kepada wartawan, Jumat (24/11/2023).\n" +
                "\n" +
                "Halim menjelaskan, aturan itu dibuat agar masyarakat taat pajak dan memahami ketentuan-ketentuan yang ada. Dia lalu mencontohkan mobil yang tidak membayar pajak disebut tidak layak melintas di jalan karena akan ditangkap pihak terkait"),

        beritaModel("Angka Kecelakaan di Aceh Masih Tinggi, Polisi Bikin Pos Penolong Jalan Raya", "Jumat, 24 November 2023", R.drawable.kantor_desa, "Ditlantas Polda Aceh akan meluncurkan pos penolong jalan raya untuk menolong korban kecelakaan di Tanah Rencong. Pos itu dibuat setelah melihat angka kecelakaan yang masih sangat tinggi dengan korban tewas setiap bulan di atas 35 orang.\n" +
                "\"Pos pelayanan masyarakat itu khususnya penanganan pelaporan laka lantas di jajaran pos tersebut. Nantinya akan diisi oleh Polantas dan stakeholder lain dengan kelengkapannya seperti ambulans, mobil unit laka dan lain-lain,\" kata Dirlantas Polda Aceh Kombes Muhammad Iqbal Alqudusy kepada detikSumut, Jumat (24/11/2023).\n" +
                "\n" +
                "Pos itu direncanakan akan berfungsi pekan depan. Menurutnya, petugas di pos tersebut akan merespons dengan cepat bila ada laporan kecelakaan lalu lintas."),

        beritaModel("Terkuaknya Penyelundupan 36 Pengungsi Rohingya yang Baru Mendarat di Aceh", "umat, 24 November 2023", R.drawable.tk, "Polisi mengungkap aksi penyelundupan 36 pengungsi Rohingya yang baru saja mendarat di bibir pantai Aceh. Mereka diselundupkan dalam bak truk berhimpit-himpitan. 1 orang sopir truk ditangkap atas kasus tersebut.\n" +
                "Sopir truk yang ditangkap berinisial, KW (27). Ia mengaku diupah Rp 3 juta untuk mengangkut pengungsi Rohingya tersebut dari lokasi pendaratan mereka di Aceh Timur.\n" +
                "\n" +
                "\"Satu orang pelaku sudah kita tangkap dan dua orang lagi sedang kita buru,\" kata Kapolres Aceh Timur AKBP Andy Rahmasyah kepada wartawan, Kamis (23/11/2023)"),

        beritaModel("514 Imigran Rohingya Ditampung di Gedung Eks Kantor Imigrasi Aceh", "Jumat, 24 November 2023", R.drawable.sd, "Sebanyak 514 orang imigran Rohingya ditampung sementara di gedung eks kantor Imigrasi Aceh. Mereka akan tinggal di sana hingga 3 bulan ke depan.\n" + "Sejumlah imigran etnis Rohingya yang dipindahkan dari Pantai Ujong Kareung Sabang menunggu pendataan setibanya di tempat penampungan sementara di gedung eks kantor Imigrasi, Punteuet, Lhokseumawe, Aceh, Kamis (23/11/2023)."),

        beritaModel("1.084 Pengungsi Rohingya Mendarat di Aceh dalam 2 Pekan", "Jumat, 24 November 2023", R.drawable.tpa, "Sebanyak 1.084 pengungsi Rohingya mendarat di sejumlah daerah di Aceh dalam dua pekan terakhir. Mereka tiba menggunakan enam perahu kayu.\n" +
                "Kapal pertama rombongan Rohingya mendarat di Pidie pada Selasa (14/11) sore. Setelah itu, rombongan imigran yang terdiri dari anak-anak, perempuan dan laki-laki mendarat di Pidie, Bireuen, Aceh Timur serta Sabang.\n" +
                "\n" +
                "\"Divisi Imigrasi Kantor Wilayah Kementerian Hukum dan Hak Asasi Manusia Aceh dalam kurun waktu bulan November yaitu sejak tanggal 14 November sampai dengan 21 November telah menerima laporan serta menangani sebanyak 1.084 pengungsi etnis Rohingya yang datang ke Indonesia menggunakan perahu kayu,\" kata Kepala Divisi Keimigrasian Kanwil Kemenkumham Aceh Ujo Sujoto kepada wartawan, Kamis (23/11/2023)")
    )

}