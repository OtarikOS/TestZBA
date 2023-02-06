package com.koshkin.android.testzba.presentation.mapperspr

import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.presentation.entitypr.DetailInfo
import com.koshkin.android.testzba.presentation.entitypr.Item

class DetailMapper {
    fun toDetailInfoMapper(binEntities: ArrayList<BinEntities>):ArrayList<Item>{
        var detailInfo= arrayListOf<DetailInfo>()
       for(i in 0..binEntities.size-1){
           detailInfo[i].alpha2 = binEntities[i].alpha2
           detailInfo[i].brand = binEntities[i].brand
           detailInfo[i].city = binEntities[i].city
           detailInfo[i].emoji = binEntities[i].emoji
           detailInfo[i].currency = binEntities[i].currency
           detailInfo[i].latitude = binEntities[i].latitude
           detailInfo[i].length = binEntities[i].length
           detailInfo[i].longitude = binEntities[i].longitude
           detailInfo[i].luhn = binEntities[i].luhn
           detailInfo[i].nameCountry = binEntities[i].nameCountry
           detailInfo[i].numeric = binEntities[i].numeric
           detailInfo[i].phone = binEntities[i].phone
           detailInfo[i].prepaid = binEntities[i].prepaid
           detailInfo[i].type = binEntities[i].type
           detailInfo[i].url = binEntities[i].url
           detailInfo[i].scheme = binEntities[i].scheme
       }
        return detailInfo

//            scheme = binEntities.scheme,
//            alpha2 = binEntities.alpha2,
//            brand = binEntities.brand,
//            city = binEntities.city,
//            currency = binEntities.currency,
//            emoji = binEntities.emoji,
//            latitude = binEntities.latitude,
//            length = binEntities.length,
//            longitude = binEntities.longitude,
//            luhn = binEntities.luhn,
//            nameCountry = binEntities.nameCountry,
//            numeric = binEntities.numeric,
//            phone = binEntities.phone,
//            prepaid = binEntities.prepaid,
//            type = binEntities.type,
//            url = binEntities.url
//

}
}