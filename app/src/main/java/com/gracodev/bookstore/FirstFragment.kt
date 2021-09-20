package com.gracodev.bookstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.gracodev.bookstore.adapters.BestSellerAdapter
import com.gracodev.bookstore.adapters.BookAdapter
import com.gracodev.bookstore.databinding.FragmentFirstBinding
import com.gracodev.bookstore.factories.BookFactory
import com.gracodev.bookstore.models.Book
import com.gracodev.bookstore.models.BookData
import com.gracodev.bookstore.viewmodels.BookViewModel
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: BookFactory by instance()
    private lateinit var viewModel: BookViewModel
    private lateinit var binding: FragmentFirstBinding

    private lateinit var books: List<Book>
    private lateinit var bestSeller: List<BookData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)

        viewModel = ViewModelProvider(this, factory).get()

        binding.viewmodel = viewModel

        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getBooksReponse.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let { response ->
                if (response.results != null) {
                    books = response.results!!.books
                    booksRecyclerView.adapter = BookAdapter(books)
                }
            }
        })

        viewModel.getBestSellersReponse.observe(viewLifecycleOwner, {
            it.getContentIfNotHandled()?.let { response ->
                if (response.results != null) {
                    bestSellersRecyclerView.adapter = BestSellerAdapter(books.filter {
                        it.isbn in response.results!!.best_sellers
                    })
                }
            }
        })

        lifecycleScope.launch {
            viewModel.getBooks()
            viewModel.getBestSellers()
        }

    }
}