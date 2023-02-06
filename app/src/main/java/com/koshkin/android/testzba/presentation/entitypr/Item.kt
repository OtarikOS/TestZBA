package com.koshkin.android.testzba.presentation.entitypr

import com.koshkin.android.testzba.data.entities.BinEntities

data class Item(
    var id: Int,
    var nameBank: String,
    val nestedItems: List<DetailInfo>
)
data  class DetailInfo (
    var scheme:String?,
    var type:String?,
    var brand:String?,
    var prepaid:Boolean?,

    var numeric: String?,
    var alpha2: String?,
    var nameCountry: String?,
    var emoji: String?,
    var currency: String?,
    var latitude: Int?,
    var longitude: Int?,

    var length : Int?,
    var luhn   : Boolean?,

    var url   : String?,
    var phone : String?,
    var city  : String?,
    )

