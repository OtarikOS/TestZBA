package com.koshkin.android.testzba.data.mappers

import com.koshkin.android.testzba.data.api.BinApiResponse
import com.koshkin.android.testzba.domain.entities.BinCard
import com.squareup.moshi.Json

class BinApiResponseMapper {
    fun toBin(response: BinApiResponse): BinCard {
        BinCard(
            it.number,

            @field: Json(name = "number")
        val number: Number?,
            @field: Json(name = "scheme")
            val scheme: String?,
            @field: Json(name = "type")
            val type: String?,
            @field: Json(name = "brand")
            val brand: String?,
            @field: Json(name = "prepaid")
            val prepaid: Boolean?,
            @field: Json(name = "country")
            val country: Country?,
            @field: Json(name = "bank")
            val bank: Bank?,

        )
    }
}