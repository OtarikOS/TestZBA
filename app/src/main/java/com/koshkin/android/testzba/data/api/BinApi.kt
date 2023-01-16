package com.koshkin.android.testzba.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BinApi {
    @GET("volumes")
    suspend fun getBin(@Query("q") author: String):Response<BinApiResponse>
}