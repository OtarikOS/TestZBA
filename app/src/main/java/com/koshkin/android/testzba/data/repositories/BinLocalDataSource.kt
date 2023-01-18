package com.koshkin.android.testzba.data.repositories

import com.koshkin.android.testzba.domain.entities.BinCard
import kotlinx.coroutines.flow.Flow

interface BinLocalDataSource {
    suspend fun saveBinCard(bin: BinCard)

    suspend fun deleteBinCard(bin: BinCard)

    suspend fun getSavedBins(): Flow<List<BinCard>>
}