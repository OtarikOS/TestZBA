package com.koshkin.android.testzba.domain.entities

data class BinCard(
    val number: BinNumber?,
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val prepaid: Boolean?,
    val country: BinCountry?,
    val bank: BinBank?,
)
