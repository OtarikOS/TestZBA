package com.koshkin.android.testzba.data.mappers

import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.entities.BinBank
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.entities.BinCountry
import com.koshkin.android.testzba.domain.entities.BinNumber

class BinEntityMapper {
    fun toBinEntities(
        binCard: BinCard,
      /*  binCountry: BinCountry,
        binBank: BinBank,
        binNumber: BinNumber*/
    ): BinEntities {
        return BinEntities(
            id = 1,//TODO
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

    fun toBinCard(binEntities: BinEntities): BinCard {
        return BinCard(
            BinNumber(
                length = binEntities.length,
                luhn = binEntities.luhn
            ),
            scheme = binEntities.scheme,
            type = binEntities.type,
            brand = binEntities.brand,
            prepaid = binEntities.prepaid,
            BinCountry(
                numeric = binEntities.numeric,
                alpha2 = binEntities.alpha2,
                name = binEntities.nameCountry,
                emoji = binEntities.emoji,
                currency = binEntities.currency,
                latitude = binEntities.latitude,
                longitude = binEntities.longitude
            ),
            BinBank(
                name = binEntities.nameBank,
                url = binEntities.url,
                phone = binEntities.phone,
                city = binEntities.city
            )
        )
    }
}