package com.koshkin.android.testzba.data.mappers

import android.util.Log
import com.koshkin.android.testzba.data.api.BinApiResponse
import com.koshkin.android.testzba.domain.entities.BinBank
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.entities.BinCountry
import com.koshkin.android.testzba.domain.entities.BinNumber
import com.squareup.moshi.Json

class BinApiResponseMapper {
    fun toBin(response: BinApiResponse): BinCard {
        Log.i("TOBIN",response.toString())
        return BinCard(
            BinNumber(
                length = response.cardData.number?.length,
                luhn = response.cardData.number?.luhn
            ),
            scheme = response.cardData.scheme,
            type = response.cardData.type,
            brand = response.cardData.brand,
            prepaid = response.cardData.prepaid,
            BinCountry(
                numeric = response.cardData.country?.numeric,
                alpha2 = response.cardData.country?.alpha2,
                name = response.cardData.country?.name,
                emoji = response.cardData.country?.emoji,
                currency = response.cardData.country?.currency,
                latitude = response.cardData.country?.latitude,
                longitude = response.cardData.country?.longitude
            ),
            BinBank(
                name = response.cardData.bank?.name,
                url = response.cardData.bank?.url,
                phone = response.cardData.bank?.phone,
                city = response.cardData.bank?.city
            )

        )
    }
}