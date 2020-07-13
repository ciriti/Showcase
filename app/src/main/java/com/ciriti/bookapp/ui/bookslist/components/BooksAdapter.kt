package com.ciriti.bookapp.ui.bookslist.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ciriti.bookapp.R
import java.security.InvalidParameterException

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.Vh>() {

    companion object {
        val ASC_BY_RANK = compareBy<Book4View> { it.rank }
        val DESC_BY_FAVORITES = compareBy<Book4View> { -it.weeksOnList }
    }

    private var list = mutableListOf<Book4View>()
    private var comparator = ASC_BY_RANK

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return Vh(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.bind(list[position], position)
    }

    class Vh(val view: View) : RecyclerView.ViewHolder(view)

    private fun Vh.bind(iv: Book4View, pos: Int) {
        (view as? BookItemView)?.let {
            view.bind(iv, pos)
        } ?: throw InvalidParameterException("Error")
    }

    fun addItems(newItems: List<Book4View>) {
        list.clear()
        list.addAll(newItems.sortedWith(ASC_BY_RANK))
        notifyDataSetChanged()
    }

    fun sort(comparator: Comparator<Book4View>) {
        this.comparator = comparator
        list = list.sortedWith(comparator).toMutableList()
        notifyDataSetChanged()
    }
}
