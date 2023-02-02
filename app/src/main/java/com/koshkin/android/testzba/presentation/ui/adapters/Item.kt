package com.koshkin.android.testzba.presentation.ui.adapters

data class Item(
    val id: Int,
    val text: String,
    val nestedItems: List<String>
)
