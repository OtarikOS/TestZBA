package com.koshkin.android.testzba.presentation.mapperspr

import com.koshkin.android.testzba.domain.entities.BinBank
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.entities.BinCountry
import com.koshkin.android.testzba.domain.entities.BinNumber
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr

class BinEntityMapperPr {
    fun fromBinCardToBinEntityPr(
        binCard: BinCard,id:Int
    ): BinEntityPr {
        return BinEntityPr(
            id = id,
            scheme = binCard.scheme,
            type = binCard.type,
            brand = binCard.brand,
            prepaid = binCard.prepaid,
            numeric = binCard.country?.numeric,
            alpha2 = binCard.country?.alpha2,
            nameCountry = binCard.country?.name,
            emoji = binCard.country?.emoji,
            currency = binCard.country?.currency,
            latitude = binCard.country?.latitude,
            longitude = binCard.country?.longitude,
            length = binCard.number?.length,
            luhn = binCard.number?.luhn,
            nameBank = binCard.bank?.name,
            url = binCard.bank?.url,
            phone = binCard.bank?.phone,
            city = binCard.bank?.city
        )
    }

    fun fromEntityPrToBinCard(binEntityPr: BinEntityPr): BinCard {
        return BinCard(
            BinNumber(
                length = binEntityPr.length,
                luhn = binEntityPr.luhn
            ),
            scheme = binEntityPr.scheme,
            type = binEntityPr.type,
            brand = binEntityPr.brand,
            prepaid = binEntityPr.prepaid,
            BinCountry(
                numeric = binEntityPr.numeric,
                alpha2 = binEntityPr.alpha2,
                name = binEntityPr.nameCountry,
                emoji = binEntityPr.emoji,
                currency = binEntityPr.currency,
                latitude = binEntityPr.latitude,
                longitude = binEntityPr.longitude
            ),
            BinBank(
                name = binEntityPr.nameBank,
                url = binEntityPr.url,
                phone = binEntityPr.phone,
                city = binEntityPr.city
            )
        )
    }
}