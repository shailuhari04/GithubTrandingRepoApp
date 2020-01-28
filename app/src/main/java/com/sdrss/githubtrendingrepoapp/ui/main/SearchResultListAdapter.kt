package com.sdrss.githubtrendingrepoapp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.sdrss.githubtrendingrepoapp.R
import com.sdrss.githubtrendingrepoapp.binding.BindingViewHolder
import com.sdrss.githubtrendingrepoapp.data.remote.response.RepositoriesResponse
import com.sdrss.githubtrendingrepoapp.databinding.RowItemBinding

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
        holder.binding.expendView = holder.binding.llMore
    }

    inner class ViewHolder(itemView: View) : BindingViewHolder<RowItemBinding>(itemView)

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
