package com.koshkin.android.testzba.presentation.entitypr

data class BinEntityPr (

    val id:Int,
    val scheme:String?,
    val type:String?,
    val brand:String?,
    val prepaid:Boolean?,

    val numeric: String?,
    val alpha2: String?,
    val nameCountry: String?,
    val emoji: String?,
    val currency: String?,
    val latitude: Int?,
    val longitude: Int?,

    val length : Int?     ,
    val luhn   : Boolean?,

    val nameBank  : String?,
    val url   : String? ,
    val phone : String? ,
    val city  : String? ,

    )