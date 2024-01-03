package com.example.apk_pelayanan_publik_desa_jatirejo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apk_pelayanan_publik_desa_jatirejo.R
import com.example.apk_pelayanan_publik_desa_jatirejo.model.ChatMessage

class ChatAdapter(private val messageList: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messageList[position]
        holder.messageTextView.text = currentMessage.text
    }

    override fun getItemCount(): Int {
        return messageList.size
    }
}