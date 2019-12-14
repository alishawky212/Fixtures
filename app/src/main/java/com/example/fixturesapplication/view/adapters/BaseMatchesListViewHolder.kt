package com.example.fixturesapplication.view.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fixturesapplication.model.ListItem

abstract class BaseMatchesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind()
}