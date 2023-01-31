package com.koshkin.android.testzba.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BinApi {
    @GET("/{id}")
    suspend fun getBin(@Path("id") cardId:Int):Response<CardData>
}