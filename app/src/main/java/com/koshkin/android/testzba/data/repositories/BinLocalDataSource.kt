package com.koshkin.android.testzba.data.repositories

import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr
import kotlinx.coroutines.flow.Flow

interface BinLocalDataSource {
    suspend fun saveBinCard(bin: BinEntities)

    suspend fun deleteBinCard(bin: BinEntities)

    suspend fun getSavedBins(): Flow<List<BinEntities>>
}