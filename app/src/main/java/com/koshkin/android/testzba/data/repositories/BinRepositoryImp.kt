package com.koshkin.android.testzba.data.repositories

import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.domain.repositories.BinRepository
import kotlinx.coroutines.flow.Flow

class BinRepositoryImp(
    val localDataSource: BinLocalDataSource,
    val remoteDataSource: BinRemoteDataSource
):BinRepository {
    override suspend fun getRemoteBin(id: Int): Result<BinCard> {
        return remoteDataSource.getBinInfo(id)
    }

    override suspend fun saveBinCard(bin: BinCard) {
        return localDataSource.saveBinCard(bin)
    }

    override suspend fun deleteBinCard(bin: BinCard) {
        return localDataSource.deleteBinCard(bin)
    }

    override suspend fun getSavedBins(): Flow<List<BinCard>> {
        return localDataSource.getSavedBins()
    }
}