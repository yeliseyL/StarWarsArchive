package com.example.starwarsarchive.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.starwarsarchive.R
import com.example.starwarsarchive.mvp.presenter.list.ICategoryListPresenter
import com.example.starwarsarchive.mvp.view.list.IItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_item.view.*

class CategoryRVAdapter(val presenter : ICategoryListPresenter<IItemView>) : RecyclerView.Adapter<CategoryRVAdapter.ViewHolder>() {

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer, IItemView {
        override var pos = -1

        override fun setTitle(text: String) = with(containerView) {
            title.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }
}