package com.example.anchorbooks_sem1

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.anchorbooks_sem1.model.Books

class AdapterBooks: RecyclerView.Adapter<AdapterBooks.BooksVMolder> () {
    private var listAdapterBooks = listOf<Books>()

    var booksItem = MutableLiveData<Books>()

    fun booksItem(): LiveData<Books> = booksItem

    fun update(list: List<Books>) {
        listAdapterBooks = list
        notifyDataSetChanged()
    }

    inner class BooksVHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        fun bind(anchorBooksEntity: Books) {
            Glide.with(binding.ivImageLink).load(anchorBooksEntity.imageLink)
                .into(binding.ivImageLink)
            if (Books.fav) {
                binding.ivFav.setColorFilter(Color.BLUE)
            } else {
                binding.ivFav.setColorFilter(Color.BLACK)
            }
            binding.tvTitle.text = anchorBooksEntity.title

        }

        override fun onClick(v: View?) {
            booksItem.value = listAdapterBooks[adapterPosition]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        return BooksVHolder(ItemBooksBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BooksVHolder, position: Int) {
        val booksDC = listAdapterBooks[position]
        holder.bind(booksDC)
    }

    override fun getItemCount(): Int = listAdapterBooks.size
}