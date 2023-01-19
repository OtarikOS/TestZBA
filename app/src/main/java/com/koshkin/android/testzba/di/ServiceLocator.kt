package com.koshkin.android.testzba.di

import android.content.Context
import com.koshkin.android.testzba.BuildConfig
import com.koshkin.android.testzba.data.api.NetworkService
import com.koshkin.android.testzba.data.db.BinDataBase
import com.koshkin.android.testzba.data.mappers.BinApiResponseMapper
import com.koshkin.android.testzba.data.mappers.BinEntityMapper
import com.koshkin.android.testzba.data.repositories.BinLocalDataSource
import com.koshkin.android.testzba.data.repositories.BinLocalDataSourceImp
import com.koshkin.android.testzba.data.repositories.BinRemoteDataSourceImp
import com.koshkin.android.testzba.data.repositories.BinRepositoryImp
import kotlinx.coroutines.Dispatchers


object ServiceLocator {
    private  var dataBase: BinDataBase? = null
    private  val networkService by lazy {
        NetworkService()
    }
    private val binEntityMapper: BinEntityMapper by lazy {
        BinEntityMapper()
    }
    @Volatile
    var binRepository: BinRepositoryImp? = null

    fun provideBinRepository(context: Context) : BinRepositoryImp{
        synchronized(this){
            return binRepository ?: createBinRepository(context)
        }
    }

    private fun createBinRepository(context: Context) :BinRepositoryImp {
        val newRepo =
            BinRepositoryImp(createBinLocalDataSource(context),BinRemoteDataSourceImp(networkService.createBinApi(
                BuildConfig.BIN_APIS_ENDPOINT), BinApiResponseMapper()
            ))
        binRepository= newRepo
        return newRepo
    }

    private fun createBinLocalDataSource(context: Context): BinLocalDataSource {
        val dataBase =dataBase ?: createDataBase(context)
        return BinLocalDataSourceImp(
            dataBase.binDao(),
            Dispatchers.IO,
            binEntityMapper
        )
    }

    private fun createDataBase(context: Context): BinDataBase {
        val result = BinDataBase.getDataBase(context)
        dataBase = result
        return result
    }

}