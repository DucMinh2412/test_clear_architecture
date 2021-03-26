package com.example.test_clear_architecture.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


abstract class BaseListAdapter<T, VH : BaseViewHolder>(
        callback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, VH>(callback) {

    override fun onBindViewHolder(
            holder: VH,
            position: Int
    ) {
        holder.onBind(position)
    }

    open fun setData(data: List<T>?) {
        submitList(data)
    }
}
