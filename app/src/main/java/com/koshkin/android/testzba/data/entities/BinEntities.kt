package com.koshkin.android.testzba.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Bin")
data class BinEntities (
    @PrimaryKey
    val id:Int,
    val number:String?,
    val scheme:String?,
    val type:String?,
    val brand:String?,
    val prepaid:String?,
    val country:String?,
    val bank:String?,

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