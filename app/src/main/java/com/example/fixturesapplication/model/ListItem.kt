package com.example.fixturesapplication.model

abstract class ListItem {
    abstract fun getType(): ItemType
}

enum class ItemType{
    TYPE_DATE,TYPE_GENERAL
}