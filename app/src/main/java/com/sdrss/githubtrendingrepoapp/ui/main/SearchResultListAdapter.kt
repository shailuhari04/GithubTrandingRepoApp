package com.sdrss.githubtrendingrepoapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.binding.BindingViewHolder
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrendingrepoapp.databinding.RowItemBinding
import com.sdrss.githubtrendingrepoapp.utils.gone
import com.sdrss.githubtrendingrepoapp.utils.visible
import kotlinx.android.synthetic.main.row_item.view.*

/**
 * @author SDRSS
 */
class SearchResultListAdapter :
    ListAdapter<RepositoriesResponse, SearchResultListAdapter.ViewHolder>(RepoDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.item = item
        if (item.isExpanded) {
            holder.itemView.group.visible()
        } else {
            holder.itemView.group.gone()
        }
    }

    inner class ViewHolder(itemView: View) :
        BindingViewHolder<RowItemBinding>(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition == RecyclerView.NO_POSITION) return

            with(itemView.group) {
                currentList[adapterPosition].hasLanguage =
                    currentList[adapterPosition].language != null
                notifyItemChanged(adapterPosition)

                when (this.visibility) {
                    View.VISIBLE -> {
                        this.gone() //using extension function setVisibility
                        currentList[adapterPosition].isExpanded = false //update the state
                    }
                    View.GONE -> {
                        this.visible() //using extension function setVisibility
                        currentList[adapterPosition].isExpanded = true //update the state
                    }
                }
            }
        }
    }

    private class RepoDiffUtil : DiffUtil.ItemCallback<RepositoriesResponse>() {
        override fun areItemsTheSame(
            oldItem: RepositoriesResponse,
            newItem: RepositoriesResponse
        ) = oldItem.name == newItem.name

        override fun areContentsTheSame(
            oldItem: RepositoriesResponse,
            newItem: RepositoriesResponse
        ) = oldItem == newItem
    }
}
