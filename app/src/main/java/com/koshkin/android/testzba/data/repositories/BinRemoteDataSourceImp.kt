package com.koshkin.android.testzba.data.repositories

import android.util.Log
import com.koshkin.android.testzba.data.api.BinApi
import com.koshkin.android.testzba.data.mappers.BinApiResponseMapper
import com.koshkin.android.testzba.domain.entities.BinCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.koshkin.android.testzba.domain.common.Result



class BinRemoteDataSourceImp(
    val service: BinApi,
    val mapper: BinApiResponseMapper
):BinRemoteDataSource {
    override suspend fun getBinInfo(id:Int): Result<BinCard>  = withContext(Dispatchers.IO){
        try {
            val response = service.getBin(/*id*/)
            if(response.isSuccessful){
                Log.i("BINREM_D_S_IMP сработал", service.getBin().body()?.toString()!!)
                return@withContext Result.Success(mapper.toBin(response.body()!!))
            }else
                return@withContext Result.Error(Exception(response.message()))
        }catch (e:Exception){
            Log.i("BINREM_D_S_IMP", service.getBin().body()?.toString()!!)
            Log.i("BINREM_D_S_IMP",service.getBin().isSuccessful.toString())
            return@withContext Result.Error(e)
        }
    }
}