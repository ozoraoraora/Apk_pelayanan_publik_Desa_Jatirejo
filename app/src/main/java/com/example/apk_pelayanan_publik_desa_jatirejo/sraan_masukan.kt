package com.example.apk_pelayanan_publik_desa_jatirejo

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.adapter.ChatAdapter
import com.example.apk_pelayanan_publik_desa_jatirejo.model.ChatMessage

class sraan_masukan : AppCompatActivity() {
    private lateinit var messageEditText: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter

    private val messageList = mutableListOf<ChatMessage>() // Ganti tipe data di sini

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sraan_masukan)

        //Atur toolbar sebagai support action bar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)


        //Setting toolbar
        supportActionBar?.apply {
            title = "Desa Jatirejo"
            subtitle = " Saran dan Masukan"

            setDisplayShowCustomEnabled(true)
            setLogo(R.drawable.ic_nagan)
            setDisplayUseLogoEnabled(true)

        }

        messageEditText = findViewById(R.id.messageEditText)
        sendButton = findViewById(R.id.sendButton)
        recyclerView = findViewById(R.id.recyclerView)

        chatAdapter = ChatAdapter(messageList)
        recyclerView.adapter = chatAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        sendButton.setOnClickListener {
            val messageText = messageEditText.text.toString().trim()
            if (messageText.isNotEmpty()) {
                addMessage(ChatMessage(messageText, true)) // Ganti di sini juga
                messageEditText.text.clear()
                // Tambahkan logika untuk menyimpan pesan ke penyimpanan atau backend
            }
        }
    }



    private fun addMessage(message: ChatMessage) {
        messageList.add(message)
        chatAdapter.notifyItemInserted(messageList.size - 1)
        recyclerView.smoothScrollToPosition(messageList.size - 1)
    }
}



//    private lateinit var messageEditText: EditText
//    private lateinit var sendButton: Button
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var chatAdapter: ChatAdapter
//
//    private val messageList = mutableListOf<Message>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sraan_masukan)
//
//        messageEditText = findViewById(R.id.messageEditText)
//        sendButton = findViewById(R.id.sendButton)
//        recyclerView = findViewById(R.id.recyclerView)
//
//        chatAdapter = ChatAdapter(messageList)
//        recyclerView.adapter = chatAdapter
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        sendButton.setOnClickListener {
//            val messageText = messageEditText.text.toString().trim()
//            if (messageText.isNotEmpty()) {
//                addMessage(Message(messageText, true))
//                messageEditText.text.clear()
//                // Tambahkan logika untuk menyimpan pesan ke penyimpanan atau backend
//            }
//        }
//
//    }
//    private fun addMessage(message: Message) {
//        messageList.add(message)
//        chatAdapter.notifyItemInserted(messageList.size - 1)
//        recyclerView.smoothScrollToPosition(messageList.size - 1)
//    }
//
//}