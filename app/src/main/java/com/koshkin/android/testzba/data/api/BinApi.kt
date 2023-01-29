package com.koshkin.android.testzba.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BinApi {
    @GET("40587032")
    suspend fun getBin(/*@Query("q") id:Int*/):Response<BinApiResponse>
}