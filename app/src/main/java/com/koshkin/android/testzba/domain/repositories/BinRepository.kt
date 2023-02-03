package com.koshkin.android.testzba.domain.repositories

import com.koshkin.android.testzba.data.api.CardData
import com.koshkin.android.testzba.data.entities.BinEntities
import com.koshkin.android.testzba.domain.common.Result
import com.koshkin.android.testzba.domain.entities.BinCard
import com.koshkin.android.testzba.presentation.entitypr.BinEntityPr


interface BinRepository {
    suspend fun getRemoteBin(id:Int): Result<BinCard>

    suspend fun saveBinCard(bin: BinEntities)

    suspend fun deleteBinCard(bin: BinEntities)

    suspend fun getSavedBins(): List<BinEntities>
}