package com.koshkin.android.testzba.data.api

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.koshkin.android.testzba.data.api.HelperSsl.getUnsafeOkHttpClient
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class NetworkService  {
  //  private val moshi by lazy {
 //       val moshBuilder= Moshi.Builder()
//            .add(KotlinJsonAdapterFactory())
//         moshBuilder.build()
//     val jsonAdapter: JsonAdapter<CardData> = moshi.adapter(Class<CardData>())
//    }

    private  val gson by lazy {
         GsonBuilder().create()
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
        Log.i("GET_RET","build")
        return Retrofit.Builder()
            .baseUrl(endpointUrl)
            .client(httpClient)
      //     .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

    }
    fun createBinApi(endpointUrl: String):BinApi{
        val retrofit = getRetrofit(endpointUrl)
        return retrofit.create(BinApi::class.java)
    }
}