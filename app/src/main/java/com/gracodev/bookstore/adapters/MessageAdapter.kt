package com.gracodev.bookstore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.gracodev.bookstore.R
import com.gracodev.bookstore.databinding.ChatItemDateBinding
import com.gracodev.bookstore.databinding.ChatItemReceiverBinding
import com.gracodev.bookstore.databinding.ChatItemSenderBinding
import com.gracodev.bookstore.models.MessageModel
import com.gracodev.bookstore.models.MessageType
import com.gracodev.extensions.loadUrl
import kotlinx.android.synthetic.main.chat_item_date.view.*
import kotlinx.android.synthetic.main.chat_item_receiver.view.*
import kotlinx.android.synthetic.main.chat_item_sender.view.*

class MessageAdapter internal constructor(
    private val items: List<MessageModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            MessageType.RECEIVER -> MessageType.RECEIVER.ordinal
            MessageType.SENDER -> MessageType.SENDER.ordinal
            MessageType.TIMESTAMP -> MessageType.TIMESTAMP.ordinal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MessageType.RECEIVER.ordinal -> {
                ReceiverViewHolder(
                    ChatItemReceiverBinding.bind(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.chat_item_receiver, parent, false)
                    )
                )
            }
            MessageType.SENDER.ordinal -> {
                SenderViewHolder(
                    ChatItemSenderBinding.bind(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.chat_item_sender, parent, false)
                    )
                )
            }
            MessageType.TIMESTAMP.ordinal -> {
                DateViewHolder(
                    ChatItemDateBinding.bind(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.chat_item_date, parent, false)
                    )
                )
            }
            else -> {
                ReceiverViewHolder(
                    ChatItemReceiverBinding.bind(
                        LayoutInflater.from(parent.context)
                            .inflate(R.layout.chat_item_receiver, parent, false)
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (getItemViewType(position)) {
            MessageType.SENDER.ordinal -> {
                (holder as SenderViewHolder).bind(items[position])
            }

            MessageType.RECEIVER.ordinal -> {
                (holder as ReceiverViewHolder).bind(items[position])
            }

            MessageType.TIMESTAMP.ordinal -> {
                (holder as DateViewHolder).bind(items[position])
            }
            else -> {
            }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class DateViewHolder(private val binding: ChatItemDateBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MessageModel) {
        with(binding.root) {
            textViewDate.text = item.message
        }
    }

}

class SenderViewHolder(private val binding: ChatItemSenderBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MessageModel) {
        with(binding.root) {
            textViewMessageSender.isGone = item.message.isEmpty()
            textViewMessageSender.text = item.message
            imageViewSender.isVisible = item.isImage
            imageViewSender.loadUrl(item.imageUrl)
            textViewTimeStampSender.text = item.timeStamp
        }
    }
}

class ReceiverViewHolder(private val binding: ChatItemReceiverBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MessageModel) {
        with(binding.root) {
            textViewMessageReceiver.isGone = item.message.isEmpty()
            textViewMessageReceiver.text = item.message
            imageViewMessageReceiver.isVisible = item.isImage
            imageViewMessageReceiver.loadUrl(item.imageUrl)
            textViewTimeStampReceiver.text = item.timeStamp
        }
    }
}
