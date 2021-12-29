package com.shusharin.testcaseimage.ui.mainscreen.recycler

import androidx.recyclerview.widget.DiffUtil

class DiffCallback(
    private val oldList: List<String>,
    private val newList: List<String>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    // Один и тот же объект?
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem = oldList[oldItemPosition]
        val newitem = newList[newItemPosition]
        return olditem == newitem
    }

    // Если один и тот же поля одинаковые?
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val olditem = oldList[oldItemPosition]
        val newitem = newList[newItemPosition]
        return olditem == newitem
    }
}