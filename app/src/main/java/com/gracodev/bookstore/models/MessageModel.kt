package com.gracodev.bookstore.models

data class MessageModel(
    val message: String,
    val type: MessageType,
    val timeStamp: String,
    val isImage: Boolean = false,
    val imageUrl: String = ""
)

enum class MessageType {
    RECEIVER,
    SENDER,
    TIMESTAMP
}