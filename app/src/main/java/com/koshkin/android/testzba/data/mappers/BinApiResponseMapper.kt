package com.koshkin.android.testzba.data.mappers

import android.util.Log
import com.koshkin.android.testzba.data.api.CardData
import com.koshkin.android.testzba.domain.entities.BinBank
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.entities.BinCountry
import com.koshkin.android.testzba.domain.entities.BinNumber

class BinApiResponseMapper {
    fun toBin(response: CardData): BinCard {
        Log.i("TOBIN",response.toString())
        return BinCard(
            BinNumber(
                length = response.number?.length,
                luhn = response.number?.luhn
            ),
            scheme = response.scheme,
            type = response.type,
            brand = response.brand,
            prepaid = response.prepaid,
            BinCountry(
                numeric = response.country?.numeric,
                alpha2 = response.country?.alpha2,
                name = response.country?.name,
                emoji = response.country?.emoji,
                currency = response.country?.currency,
                latitude = response.country?.latitude,
                longitude = response.country?.longitude
            ),
            BinBank(
                name = response.bank?.name,
                url = response.bank?.url,
                phone = response.bank?.phone,
                city = response.bank?.city
            )

        )
    }
}