package com.koshkin.android.testzba.data.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.koshkin.android.testzba.data.api.HelperSsl.getUnsafeOkHttpClient
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class NetworkService  {
    private val moshi by lazy {
        val moshBuilder= Moshi.Builder()
            .add(com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory())
         moshBuilder.build()
       // val jsonAdapter: JsonAdapter<CardData> = moshi.adapter(Class<CardData>())
    }
    private val logginInterceptor by lazy {
        val logginInterceptor = HttpLoggingInterceptor()
        logginInterceptor.level=HttpLoggingInterceptor.Level.BODY
        logginInterceptor
    }
    private val httpClient by lazy {
        val client =getUnsafeOkHttpClient().build()
    //    OkHttpClient.Builder()
                client.newBuilder()
                    .addInterceptor(logginInterceptor)
            .build()
    }
    private  fun getRetrofit(endpointUrl:String):Retrofit{
        return Retrofit.Builder()
            .baseUrl(endpointUrl)
            .client(httpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
    fun createBinApi(endpointUrl: String):BinApi{
        val retrofit = getRetrofit(endpointUrl)
        return retrofit.create(BinApi::class.java)
    }
}