package com.koshkin.android.testzba.data.repositories

import android.util.Log
import com.koshkin.android.testzba.data.api.CardData
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.repositories.BinRepository
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr
import kotlinx.coroutines.flow.Flow

class BinRepositoryImp(
    val localDataSource: BinLocalDataSource,
    val remoteDataSource: BinRemoteDataSource
):BinRepository {
    override suspend fun getRemoteBin(id: Int): Result<BinCard> {
        Log.i("BIN_REP_IMP",remoteDataSource.getBinInfo(id).toString())
        return remoteDataSource.getBinInfo(id)
    }

    override suspend fun saveBinCard(bin: BinEntities) {
        return localDataSource.saveBinCard(bin)
    }

    override suspend fun deleteBinCard(bin: BinEntities) {
        return localDataSource.deleteBinCard(bin)
    }

    override suspend fun getSavedBins(): Flow<List<BinEntities>> {
        return localDataSource.getSavedBins()
    }
}