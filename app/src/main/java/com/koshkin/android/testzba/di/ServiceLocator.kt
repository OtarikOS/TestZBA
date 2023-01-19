package com.koshkin.android.testzba.di

import android.content.Context
import com.koshkin.android.testzba.
import com.koshkin.android.testzba.data.api.NetworkService
import com.koshkin.android.testzba.data.db.BinDataBase
import com.koshkin.android.testzba.data.mappers.BinEntityMapper
import com.koshkin.android.testzba.data.repositories.BinRemoteDataSourceImp
import com.koshkin.android.testzba.data.repositories.BinRepositoryImp


class ServiceLocator {
    private  val dataBase: BinDataBase? = null
    private  val networkService by lazy {
        NetworkService()
    }
    private val binEntityMapper: BinEntityMapper? by lazy {
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
                BuildConfig.
            )))
    }

}