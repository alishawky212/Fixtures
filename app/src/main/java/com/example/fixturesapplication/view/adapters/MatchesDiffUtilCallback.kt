package com.example.fixturesapplication.view.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.fixturesapplication.model.DateItem
import com.example.fixturesapplication.model.ListItem
import com.example.fixturesapplication.model.MatchUIModel

class MatchesDiffUtilCallback constructor(
    private val oldList: List<ListItem>,
    private val newList: List<ListItem>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]

        return if (oldListItem::class == newListItem::class) {
            if (oldListItem is DateItem)
                oldListItem.date == (newListItem as DateItem).date
            else
                (oldListItem as MatchUIModel).id == (newListItem as MatchUIModel).id
        } else
            false
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldListItem = oldList[oldItemPosition]
        val newListItem = newList[newItemPosition]

        return if (oldListItem::class == newListItem::class) {
            oldListItem == newListItem
        } else
            false
    }
}