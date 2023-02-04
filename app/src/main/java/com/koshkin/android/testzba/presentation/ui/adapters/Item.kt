package com.koshkin.android.testzba.presentation.ui.adapters

data class Item(
    var id: Int,
    var text: String,
    val nestedItems: List<String>
)
