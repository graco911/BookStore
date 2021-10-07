package com.gracodev.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gracodev.bookstore.adapters.MessageAdapter
import com.gracodev.bookstore.models.MessageModel
import com.gracodev.bookstore.models.MessageType
import kotlinx.android.synthetic.main.activity_multi_item_list.*

class MultiItemListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_item_list)

        recyclerViewMultiItem.adapter = MessageAdapter(mutableListOf(
            MessageModel(
                "Ayer",
                MessageType.TIMESTAMP,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hoy",
                MessageType.TIMESTAMP,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            ),
            MessageModel(
                "Hola",
                MessageType.RECEIVER,
                timeStamp = "11:40 pm"
            ),
            MessageModel(
                "Muy bien y tu? \uD83D\uDE00",
                MessageType.SENDER,
                timeStamp = "11:41 pm"
            ),
            MessageModel(
                "",
                MessageType.RECEIVER,
                "11:42 pm",
                true,
                "https://static.wikia.nocookie.net/memes-pedia/images/2/2c/89592b3392fee110134235e95d80dbf7.jpg/revision/latest/scale-to-width-down/680?cb=20200527113030&path-prefix=es"
            )
        ))

    }
}