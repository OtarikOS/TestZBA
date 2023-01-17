package com.koshkin.android.testzba.domain.repositories

import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.domain.entities.BinCard
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun getRemoteBin(id:Int): Result<BinCard>

    suspend fun saveBinCard(bin: BinCard)

    suspend fun deleteBinCard(bin: BinCard)

    suspend fun getSavedBins(): Flow<List<BinCard>>
}