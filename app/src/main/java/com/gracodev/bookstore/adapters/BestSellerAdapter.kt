package com.gracodev.bookstore.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gracodev.bookstore.R
import com.gracodev.bookstore.databinding.BookHeaderLayoutBinding
import com.gracodev.bookstore.databinding.BookItemLayoutBinding
import com.gracodev.bookstore.models.Book

class BestSellerAdapter internal constructor(
    private val items: List<Book>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val HEADER_TYPE = 1
        private const val ITEM_TYPE = 2
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].title == "HEADER") {
            return HEADER_TYPE
        } else {
            return ITEM_TYPE
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == HEADER_TYPE) {
            return BookHeaderAdapterViewHolder(
                BookHeaderLayoutBinding.bind(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.book_header_layout, parent, false
                    )
                )
            )
        } else {
            return BookAdapterViewHolder(
                BookItemLayoutBinding.bind(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.book_item_layout_horizontal, parent, false
                    )
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == HEADER_TYPE) {
            (holder as BookHeaderAdapterViewHolder).bind(items[position])
        } else {
            (holder as BookAdapterViewHolder).bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
